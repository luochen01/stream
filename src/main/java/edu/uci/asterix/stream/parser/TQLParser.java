package edu.uci.asterix.stream.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import edu.uci.asterix.stream.catalog.Catalog;
import edu.uci.asterix.stream.catalog.ObservationStream;
import edu.uci.asterix.stream.catalog.SensorCollection;
import edu.uci.asterix.stream.catalog.Table;
import edu.uci.asterix.stream.catalog.TableImpl;
import edu.uci.asterix.stream.expr.Cast;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.SortOrder;
import edu.uci.asterix.stream.expr.Window;
import edu.uci.asterix.stream.expr.aggr.Avg;
import edu.uci.asterix.stream.expr.aggr.Count;
import edu.uci.asterix.stream.expr.aggr.Max;
import edu.uci.asterix.stream.expr.aggr.Min;
import edu.uci.asterix.stream.expr.aggr.Sum;
import edu.uci.asterix.stream.expr.arithm.Add;
import edu.uci.asterix.stream.expr.arithm.Divide;
import edu.uci.asterix.stream.expr.arithm.Minus;
import edu.uci.asterix.stream.expr.arithm.Mod;
import edu.uci.asterix.stream.expr.arithm.Multiply;
import edu.uci.asterix.stream.expr.arithm.Negation;
import edu.uci.asterix.stream.expr.fields.ArrayGetItem;
import edu.uci.asterix.stream.expr.fields.As;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.expr.fields.FunctionCall;
import edu.uci.asterix.stream.expr.fields.Literal;
import edu.uci.asterix.stream.expr.fields.StructGetField;
import edu.uci.asterix.stream.expr.logic.And;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.expr.logic.False;
import edu.uci.asterix.stream.expr.logic.GreaterThan;
import edu.uci.asterix.stream.expr.logic.GreaterThanOrEqualTo;
import edu.uci.asterix.stream.expr.logic.In;
import edu.uci.asterix.stream.expr.logic.IsNull;
import edu.uci.asterix.stream.expr.logic.LessThan;
import edu.uci.asterix.stream.expr.logic.LessThanOrEqualTo;
import edu.uci.asterix.stream.expr.logic.Like;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.expr.logic.Not;
import edu.uci.asterix.stream.expr.logic.NotEqualTo;
import edu.uci.asterix.stream.expr.logic.NotNull;
import edu.uci.asterix.stream.expr.logic.Or;
import edu.uci.asterix.stream.expr.logic.PredicateExpr;
import edu.uci.asterix.stream.expr.logic.True;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.function.Function;
import edu.uci.asterix.stream.logical.LogicalFilter;
import edu.uci.asterix.stream.logical.LogicalGroupby;
import edu.uci.asterix.stream.logical.LogicalJoin;
import edu.uci.asterix.stream.logical.LogicalLimit;
import edu.uci.asterix.stream.logical.LogicalPlan;
import edu.uci.asterix.stream.logical.LogicalProject;
import edu.uci.asterix.stream.logical.LogicalSensorScan;
import edu.uci.asterix.stream.logical.LogicalSort;
import edu.uci.asterix.stream.logical.LogicalStreamScan;
import edu.uci.asterix.stream.logical.LogicalTableScan;
import edu.uci.asterix.stream.logical.analyzer.CNFNormalizer;
import edu.uci.asterix.stream.logical.analyzer.IdentifyAggregateExprs;
import edu.uci.asterix.stream.logical.analyzer.IdentifyJoinConditions;
import edu.uci.asterix.stream.parser.gen.TQLBaseVisitor;
import edu.uci.asterix.stream.parser.gen.TQLLexer;
import edu.uci.asterix.stream.parser.gen.TQLParser.AggrContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.AndContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Any_nameContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.ArithmeticContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Array_get_itemContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.BooleanContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.CastContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.ComparisonContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.CountContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Field_accessContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.FromContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.From_streamContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.FunctionContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Group_byContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.InContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Is_nullContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.LikeContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.LimitContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.LiteralContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Literal_valueContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Logic_parenthesesContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.NegativeContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.NotContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Not_nullContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.OrContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Order_byContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.ParenthesesContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.ParseContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.SelectContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Select_stmtContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Select_stream_stmtContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Stream_windowContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.TableContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.Time_intervalContext;
import edu.uci.asterix.stream.parser.gen.TQLParser.WhereContext;
import edu.uci.asterix.stream.utils.Assertion;

public class TQLParser {

    private final QueryContext queryContext = new QueryContext();

    public QueryContext parse(String file) throws IOException {

        CharStream charStream = CharStreams.fromFileName("src/test/resources/test.tql");
        TQLLexer lexer = new TQLLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        edu.uci.asterix.stream.parser.gen.TQLParser parser = new edu.uci.asterix.stream.parser.gen.TQLParser(
                tokenStream);
        parser.addErrorListener(new ThrowingErrorListener());
        ParseTree tree = parser.parse();

        tree.accept(new QueryVisitor());
        return queryContext;
    }

    private String getStringContent(String value) {
        if (value.isEmpty()) {
            return value;
        }
        char begin = value.charAt(0);
        if (begin == '\'' || begin == '"' || begin == '`') {
            char last = value.charAt(value.length() - 1);
            Assertion.asserts(begin == last);
            return value.substring(1, value.length() - 1);
        } else {
            return value;
        }
    }

    private class ThrowingErrorListener extends BaseErrorListener {

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                String msg, RecognitionException e) throws ParseCancellationException {
            throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
        }
    }

    private class QueryVisitor extends TQLBaseVisitor<QueryContext> {

        @Override
        public QueryContext visitParse(ParseContext ctx) {
            ctx.define_sensor_collections().sensor_collection_name().forEach(nameCtx -> {
                String name = nameCtx.getText();
                if (queryContext.getSensorCollection(name) != null) {
                    throw new ParsingException("SensorCollection " + name + " already exists.");
                }
                queryContext.addSensorCollection(new SensorCollection(name));
            });
            ctx.define_observation_streams().observation_stream_name().forEach(nameCtx -> {
                String name = nameCtx.getText();
                if (queryContext.getObservationStream(name) != null) {
                    throw new ParsingException("ObservationStream " + name + " already exists.");
                }
                queryContext.addObservationStream(new ObservationStream(name));
            });

            //resolve definition of sensor collection
            ctx.define_sensor_collection().forEach(sensorCtx -> {
                String name = sensorCtx.sensor_collection_name().getText();
                SensorCollection sensorCollection = queryContext.getSensorCollection(name);
                if (sensorCollection == null) {
                    throw new ParsingException("Unknown SensorCollection " + name);
                }

                LogicalPlan plan = sensorCtx.select_stmt().accept(new SelectStmtVisitor());
                sensorCollection.setLogicalPlan(plan);

            });

            //resolve definition of observation stream
            ctx.define_observation_stream().forEach(streamCtx -> {
                String streamName = streamCtx.observation_stream_name().getText();
                ObservationStream stream = queryContext.getObservationStream(streamName);
                if (stream == null) {
                    throw new ParsingException("Uknown ObservationStream " + stream);
                }
                String sensorCollectionName = streamCtx.sensor_collection_name().getText();
                SensorCollection sensorCollection = queryContext.getSensorCollection(sensorCollectionName);
                if (sensorCollection == null) {
                    throw new ParsingException("Unknown SensorCollection " + sensorCollectionName);
                }
                stream.setSensorCollection(sensorCollection);
            });

            LogicalPlan streamQueryPlan = ctx.select_stream_stmt().accept(new SelectStmtVisitor());
            queryContext.setQuery(new StreamQuery(streamQueryPlan));
            return queryContext;
        }
    }

    private class SelectStmtVisitor extends TQLBaseVisitor<LogicalPlan> {

        /**
         * table name (aliased) -> table
         */
        private final Map<String, Table> accessedTables = new HashMap<>();

        private LogicalPlan currentPlan = null;

        @Override
        public LogicalPlan visitSelect_stmt(Select_stmtContext ctx) {
            currentPlan = ctx.from().accept(this);

            if (ctx.where() != null) {
                currentPlan = ctx.where().accept(this);
                //identify join condition
                IdentifyJoinConditions identify = new IdentifyJoinConditions();
                currentPlan = identify.analyze(currentPlan);
            }
            //select must not be null
            currentPlan = ctx.select().accept(this);

            return currentPlan;
        }

        @Override
        public LogicalPlan visitSelect_stream_stmt(Select_stream_stmtContext ctx) {
            currentPlan = ctx.from_stream().accept(this);
            if (ctx.where() != null) {
                currentPlan = ctx.where().accept(this);

                IdentifyJoinConditions identify = new IdentifyJoinConditions();
                currentPlan = identify.analyze(currentPlan);
            }
            if (ctx.group_by() != null) {
                currentPlan = ctx.group_by().accept(this);
            }
            if (ctx.select() != null) {
                currentPlan = ctx.select().accept(this);

                IdentifyAggregateExprs identify = new IdentifyAggregateExprs();
                currentPlan = identify.analyze(currentPlan);
            }
            if (ctx.order_by() != null) {
                currentPlan = ctx.order_by().accept(this);
            }
            if (ctx.limit() != null) {
                currentPlan = ctx.limit().accept(this);
            }
            return currentPlan;
        }

        @Override
        public LogicalPlan visitFrom_stream(From_streamContext ctx) {
            LogicalPlan from = ctx.stream_window().stream().map(tableCtx -> tableCtx.accept(this))
                    .reduce((left, right) -> new LogicalJoin(left, right, null, false)).get();
            return from;
        }

        @Override
        public LogicalPlan visitStream_window(Stream_windowContext ctx) {
            String streamName = ctx.observation_stream_name().getText();
            String aliasName = null;
            if (ctx.alias_name() != null) {
                aliasName = ctx.alias_name().getText();
            } else {
                aliasName = streamName;
            }
            ObservationStream stream = queryContext.getObservationStream(streamName);
            if (stream == null) {
                throw new ParsingException("Unknown ObservationStream " + streamName);
            }
            if (stream.getSensorCollection() == null) {
                throw new ParsingException("Undefined ObservationStream " + streamName);
            }

            int range = ctx.time_interval(0).accept(new TimeIntervalVisitor());
            int slide = ctx.time_interval(1).accept(new TimeIntervalVisitor());
            Window window = new Window(range, slide);
            accessTable(stream, aliasName);
            return new LogicalStreamScan(stream, window, aliasName);
        }

        @Override
        public LogicalPlan visitFrom(FromContext ctx) {
            LogicalPlan from = ctx.table().stream().map(tableCtx -> tableCtx.accept(this))
                    .reduce((left, right) -> new LogicalJoin(left, right, null, false)).get();
            return from;
        }

        @Override
        public LogicalPlan visitTable(TableContext ctx) {
            String tableName = ctx.table_name().getText();
            String aliasName = null;
            if (ctx.alias_name() != null) {
                aliasName = ctx.alias_name().getText();
            } else {
                aliasName = tableName;
            }
            Table table = Catalog.INSTANCE.getTable(tableName);
            if (table != null) {
                accessTable(table, aliasName);
                return new LogicalTableScan((TableImpl) table, aliasName);
            }
            SensorCollection sensorCollection = queryContext.getSensorCollection(tableName);
            if (sensorCollection != null) {
                LogicalPlan plan = sensorCollection.getLogicalPlan();
                if (plan == null) {
                    throw new ParsingException("Undefined SensorCollection " + tableName);
                }
                accessTable(sensorCollection, aliasName);
                return new LogicalSensorScan(sensorCollection, aliasName);
            }
            throw new ParsingException("Unknown Table " + tableName);
        }

        private void accessTable(Table table, String alias) {
            if (accessedTables.containsKey(alias)) {
                throw new ParsingException("Duplicated table name " + alias);
            }
            accessedTables.put(alias, table);
        }

        @Override
        public LogicalPlan visitWhere(WhereContext ctx) {
            LogicExpr expr = (LogicExpr) ctx.logic_expr()
                    .accept(new ExprVisitor(currentPlan.getSchema(), accessedTables));
            LogicExpr cnf = CNFNormalizer.INSTANCE.toCNF(expr);
            LogicalFilter filter = new LogicalFilter(currentPlan, cnf);
            return filter;
        }

        @Override
        public LogicalPlan visitSelect(SelectContext ctx) {
            List<Expr> exprs = new ArrayList<>();
            Set<String> names = new HashSet<>();
            if (ctx.column_list().result_column().isEmpty()) {
                exprs.add(new FieldAccess(Field.ALL_FIELDS, null));
            } else {
                ctx.column_list().result_column().forEach(columnCtx -> {
                    Expr expr = columnCtx.expr().accept(new ExprVisitor(currentPlan.getSchema(), accessedTables));
                    if (columnCtx.column_alias() != null) {
                        expr = new As(expr, columnCtx.column_alias().getText());
                    }
                    Field field = expr.toField();
                    if (names.contains(field.getFieldName())) {
                        throw new ParsingException("Duplicate field name" + field.getFieldName());
                    }
                    names.add(field.getFieldName());
                    exprs.add(expr);
                });
            }

            return new LogicalProject(currentPlan, exprs);
        }

        @Override
        public LogicalPlan visitGroup_by(Group_byContext ctx) {
            List<Expr> exprs = new ArrayList<>();
            ctx.field_access().forEach(fieldCtx -> {
                Expr expr = fieldCtx.accept(new ExprVisitor(currentPlan.getSchema(), accessedTables));
                exprs.add(expr);
            });

            LogicExpr havingExpr = True.INSTANCE;
            if (ctx.having() != null) {
                havingExpr = (LogicExpr) ctx.having().logic_expr()
                        .accept(new ExprVisitor(currentPlan.getSchema(), accessedTables));
            }
            LogicExpr havingCNF = CNFNormalizer.INSTANCE.toCNF(havingExpr);

            return new LogicalGroupby(currentPlan, exprs, null, havingCNF);
        }

        @Override
        public LogicalPlan visitOrder_by(Order_byContext ctx) {
            List<Expr> exprs = new ArrayList<>();
            ctx.field_access().forEach(fieldCtx -> {
                Expr expr = fieldCtx.accept(new ExprVisitor(currentPlan.getSchema(), accessedTables));
                exprs.add(expr);
            });
            SortOrder order = SortOrder.Asc;
            if (ctx.DESC() != null) {
                order = SortOrder.Desc;
            }

            return new LogicalSort(currentPlan, exprs, order);
        }

        @Override
        public LogicalPlan visitLimit(LimitContext ctx) {
            int limit = Integer.valueOf(ctx.LIMIT().getText());

            int offset = 0;
            if (ctx.OFFSET() != null) {
                offset = Integer.valueOf(ctx.OFFSET().getText());
            }
            return new LogicalLimit(currentPlan, limit, offset);
        }

    }

    private class ExprVisitor extends TQLBaseVisitor<Expr> {
        private final StructType schema;

        private final Map<String, Table> accessedTables;

        public ExprVisitor(StructType schema, Map<String, Table> accessedTables) {
            this.schema = schema;
            this.accessedTables = accessedTables;
        }

        @Override
        public Expr visitBoolean(BooleanContext ctx) {
            String text = ctx.getText().toLowerCase();
            boolean value = Boolean.valueOf(text);
            if (value) {
                return True.INSTANCE;
            } else {
                return False.INSTANCE;
            }
        }

        @Override
        public Expr visitAnd(AndContext ctx) {
            PredicateExpr left = (PredicateExpr) ctx.logic_expr(0).accept(this);
            PredicateExpr right = (PredicateExpr) ctx.logic_expr(1).accept(this);
            return new And(left, right);
        }

        @Override
        public Expr visitOr(OrContext ctx) {
            PredicateExpr left = (PredicateExpr) ctx.logic_expr(0).accept(this);
            PredicateExpr right = (PredicateExpr) ctx.logic_expr(1).accept(this);
            return new Or(left, right);
        }

        @Override
        public Expr visitNot(NotContext ctx) {
            PredicateExpr child = (PredicateExpr) ctx.logic_expr().accept(this);
            return new Not(child);
        }

        @Override
        public Expr visitArithmetic(ArithmeticContext ctx) {
            Expr left = ctx.expr(0).accept(this);
            Expr right = ctx.expr(1).accept(this);
            String operator = ctx.children.get(1).getText();
            switch (operator) {
                case "+":
                    return new Add(left, right);
                case "-":
                    return new Minus(left, right);
                case "*":
                    return new Multiply(left, right);
                case "/":
                    return new Divide(left, right);
                case "%":
                    return new Mod(left, right);
                default:
                    throw new ParsingException("Unknown arithmetic operator " + operator);
            }
        }

        @Override
        public Expr visitLike(LikeContext ctx) {
            Expr child = ctx.expr().accept(this);
            String pattern = getStringContent(ctx.STRING_LITERAL().getText());
            return new Like(child, pattern);
        }

        @Override
        public Expr visitComparison(ComparisonContext ctx) {
            Expr left = ctx.expr(0).accept(this);
            Expr right = ctx.expr(1).accept(this);
            String operator = ctx.getChild(1).getText();
            switch (operator) {
                case "=":
                    return new EqualTo(left, right);
                case "!=":
                    return new NotEqualTo(left, right);
                case ">":
                    return new GreaterThan(left, right);
                case ">=":
                    return new GreaterThanOrEqualTo(left, right);
                case "<":
                    return new LessThan(left, right);
                case "<=":
                    return new LessThanOrEqualTo(left, right);
                default:
                    throw new ParsingException("Unknown comparator " + operator);
            }
        }

        @Override
        public Expr visitCast(CastContext ctx) {
            Expr child = ctx.expr().accept(this);
            FieldTypeName typeName = null;
            if (ctx.type().INT() != null) {
                typeName = FieldTypeName.INTEGER;
            } else if (ctx.type().REAL() != null) {
                typeName = FieldTypeName.REAL;
            } else if (ctx.type().STRING() != null) {
                typeName = FieldTypeName.STRING;
            } else if (ctx.type().BOOLEAN() != null) {
                typeName = FieldTypeName.BOOLEAN;
            } else {
                throw new ParsingException("Unknown data type in " + ctx.toString());
            }

            return new Cast(child, typeName);
        }

        @Override
        public Expr visitIn(InContext ctx) {
            Expr left = ctx.expr(0).accept(this);
            Expr right = ctx.expr(1).accept(this);
            if (ctx.NOT() != null) {
                return new Not(new In(left, right));
            } else {
                return new In(left, right);
            }
        }

        @Override
        public Expr visitNot_null(Not_nullContext ctx) {
            Expr child = ctx.expr().accept(this);
            return new NotNull(child);
        }

        @Override
        public Expr visitIs_null(Is_nullContext ctx) {
            Expr child = ctx.expr().accept(this);
            return new IsNull(child);
        }

        @Override
        public Expr visitLiteral(LiteralContext ctx) {
            return ctx.literal_value().accept(this);
        }

        @Override
        public Expr visitLiteral_value(Literal_valueContext ctx) {
            if (ctx.STRING_LITERAL() != null) {
                String str = ctx.STRING_LITERAL().getText();
                return new Literal(getStringContent(str), FieldTypeName.STRING);
            } else if (ctx.INT_LITERAL() != null) {
                return new Literal(Integer.valueOf(ctx.INT_LITERAL().getText()), FieldTypeName.INTEGER);
            } else if (ctx.REAL_LITERAL() != null) {
                return new Literal(Integer.valueOf(ctx.REAL_LITERAL().getText()), FieldTypeName.REAL);
            }
            throw new ParsingException("Unknown Literal: " + ctx.getText());
        }

        @Override
        public Expr visitArray_get_item(Array_get_itemContext ctx) {
            Expr field = ctx.expr(0).accept(this);
            Expr ordinal = ctx.expr(1).accept(this);
            return new ArrayGetItem(field, ordinal);
        }

        @Override
        public Expr visitField_access(Field_accessContext ctx) {
            List<Any_nameContext> names = ctx.any_name();
            int i = 0;
            Expr result = null;
            String firstName = getStringContent(names.get(i++).getText());
            Table table = accessedTables.get(firstName);
            if (table != null) {
                if (names.size() == 1) {
                    throw new ParsingException("Invalid field access expression " + firstName);
                }
                String secondName = getStringContent(names.get(i++).getText());
                Field field = schema.getField(firstName + "." + secondName);
                if (field == null) {
                    throw new ParsingException(secondName + " is not a field of " + firstName);
                }
                result = new FieldAccess(field, schema);
            } else {
                Field field = schema.getField(firstName);
                if (field == null) {
                    throw new ParsingException("Unknown field " + firstName);
                }
                result = new FieldAccess(field, schema);
            }
            for (; i < names.size(); i++) {
                String fieldName = getStringContent(names.get(i).getText());
                result = new StructGetField(result, fieldName);
            }
            return result;
        }

        @Override
        public Expr visitCount(CountContext ctx) {
            return new Count(new FieldAccess(Field.ALL_FIELDS, null));
        }

        @Override
        public Expr visitAggr(AggrContext ctx) {
            Expr child = ctx.expr().accept(this);
            String aggrName = ctx.agg_func().getText();
            switch (aggrName.toLowerCase()) {
                case "avg":
                    return new Avg(child);
                case "sum":
                    return new Sum(child);
                case "min":
                    return new Min(child);
                case "max":
                    return new Max(child);
                default:
                    throw new ParsingException("Unknown aggregate function " + aggrName);
            }
        }

        @Override
        public Expr visitFunction(FunctionContext ctx) {
            String functionName = ctx.function_name().getText();
            Function function = Catalog.INSTANCE.getFunction(functionName);
            if (function == null) {
                throw new ParsingException("Unknown function " + functionName);
            }

            List<Expr> exprs = new ArrayList<>();
            if (ctx.parameter_list() != null) {
                ctx.parameter_list().expr().forEach(expr -> {
                    exprs.add(expr.accept(this));
                });
            }
            return new FunctionCall(function, exprs.toArray(new Expr[exprs.size()]));
        }

        @Override
        public Expr visitNegative(NegativeContext ctx) {
            Expr child = ctx.expr().accept(this);
            return new Negation(child);
        }

        @Override
        public Expr visitParentheses(ParenthesesContext ctx) {
            return ctx.expr().accept(this);
        }

        @Override
        public Expr visitLogic_parentheses(Logic_parenthesesContext ctx) {
            return ctx.logic_expr().accept(this);
        }

    }

    private class TimeIntervalVisitor extends TQLBaseVisitor<Integer> {

        @Override
        public Integer visitTime_interval(Time_intervalContext ctx) {
            int time = Integer.valueOf(ctx.INT_LITERAL().getText());
            String timeUnit = ctx.time_unit().getText().toLowerCase();
            switch (timeUnit) {
                case "seconds":
                    return time;
                case "minutes":
                    return time * 60;
                case "hours":
                    return time * 60 * 60;
                default:
                    throw new ParsingException("Unknown time unit " + timeUnit);
            }
        }
    }

}
