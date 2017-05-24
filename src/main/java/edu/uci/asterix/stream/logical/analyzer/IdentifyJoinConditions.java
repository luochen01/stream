package edu.uci.asterix.stream.logical.analyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.asterix.stream.expr.Exprs;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.expr.logic.And;
import edu.uci.asterix.stream.expr.logic.BinaryPredicateExpr;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.expr.logic.In;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.expr.logic.Or;
import edu.uci.asterix.stream.expr.logic.PredicateExpr;
import edu.uci.asterix.stream.expr.logic.True;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalFilter;
import edu.uci.asterix.stream.logical.LogicalJoin;
import edu.uci.asterix.stream.logical.LogicalPlan;

public class IdentifyJoinConditions implements LogicalPlanAnalyzer {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdentifyJoinConditions.class);

    private LogicExpr resultFilterCondition;

    @Override
    public LogicalPlan analyze(LogicalPlan plan) {
        if (!(plan instanceof LogicalFilter)) {
            return plan;
        }
        LogicalFilter filter = (LogicalFilter) plan;
        resultFilterCondition = filter.getFilterCondition();

        LogicalPlan resultChild = analyzeJoin(filter.getChild());

        return new LogicalFilter(resultChild, resultFilterCondition);
    }

    private LogicalPlan analyzeJoin(LogicalPlan plan) {
        if (!(plan instanceof LogicalJoin)) {
            return plan;
        }
        LogicalJoin join = (LogicalJoin) plan;
        LogicalPlan left = analyzeJoin(join.getLeft());
        LogicalPlan right = analyzeJoin(join.getRight());

        IdentifyJoinCondition identify = new IdentifyJoinCondition(join, resultFilterCondition);
        identify.identify();
        resultFilterCondition = identify.getSimplifiedExpr();
        LogicExpr joinCondition = identify.getJoinCondition();
        if (joinCondition == True.INSTANCE) {
            LOGGER.warn("Fail to identify join condition for " + join);
        }
        if (identify.isNeedExchange()) {
            return new LogicalJoin(right, left, joinCondition, identify.isEquiJoin());
        } else {
            return new LogicalJoin(left, right, joinCondition, identify.isEquiJoin());
        }
    }

    private class IdentifyJoinCondition {
        private final StructType leftSchema;

        private final StructType rightSchema;

        private final List<Field> allFields;

        private final LogicExpr filterExpr;

        private LogicExpr simplifiedExpr;

        private LogicExpr joinCondition;

        private boolean equiJoin = false;

        private boolean needExchange = false;

        private final List<LogicExpr> results = new ArrayList<>();

        private BinaryPredicateExpr equalCondition = null;

        public IdentifyJoinCondition(LogicalJoin join, LogicExpr filterExpr) {
            this.filterExpr = filterExpr;

            this.leftSchema = join.getLeft().getSchema();
            this.rightSchema = join.getRight().getSchema();
            this.allFields = join.getSchema().getFields();
        }

        //identify join condition from expr
        public void identify() {
            traverse(filterExpr);
            //build up join condition
            List<LogicExpr> simpliedExprs = new ArrayList<>();
            if (equalCondition != null) {
                joinCondition = equalCondition;
                equiJoin = true;
                simpliedExprs.add(equalCondition);
            } else {
                equiJoin = false;
                joinCondition = And.create(results);
                simpliedExprs.addAll(results);
            }
            simplifiedExpr = simplify(filterExpr, simpliedExprs);
            if (simplifiedExpr == null) {
                simplifiedExpr = True.INSTANCE;
            }

        }

        public boolean isNeedExchange() {
            return needExchange;
        }

        public LogicExpr getSimplifiedExpr() {
            return simplifiedExpr;
        }

        public LogicExpr getJoinCondition() {
            return joinCondition;
        }

        public boolean isEquiJoin() {
            return equiJoin;
        }

        private void traverse(LogicExpr expr) {
            if (expr instanceof And) {
                And and = (And) expr;
                traverse(and.getLeft());
                traverse(and.getRight());
            } else if (expr instanceof Or) {
                List<PredicateExpr> predicates = Exprs.collect(expr, PredicateExpr.class);
                if (predicates.stream().allMatch(pred -> checkPredicate(pred) != null)) {
                    //add or
                    results.add(expr);
                }

            } else if (expr instanceof PredicateExpr) {
                //a predicate
                PredicateExpr resultPred = checkPredicate((PredicateExpr) expr);
                if (resultPred != null) {
                    results.add(resultPred);
                    if (equalCondition == null && checkEquiCondition((PredicateExpr) expr)) {
                        equalCondition = (BinaryPredicateExpr) expr;
                    }
                }
            } else {
                throw new IllegalArgumentException("Unknown LogicExpr " + expr);
            }

        }

        private PredicateExpr checkPredicate(PredicateExpr predicate) {
            if (predicate instanceof BinaryPredicateExpr) {
                BinaryPredicateExpr comp = (BinaryPredicateExpr) predicate;
                List<Field> fields = Exprs.collect(comp, FieldAccess.class).stream().map(access -> access.toField())
                        .collect(Collectors.toList());
                boolean intersects = intersects(fields, leftSchema) && intersects(fields, rightSchema);
                boolean solvable = intersects && allFields.containsAll(fields);
                //the fields in the condition need to access both left and right schemas, and is evaluatble
                if (solvable) {
                    return comp;
                }
            }
            return null;
        }

        private boolean checkEquiCondition(PredicateExpr predicate) {
            if (predicate instanceof EqualTo || predicate instanceof In) {
                BinaryPredicateExpr equalTo = (BinaryPredicateExpr) predicate;
                List<Field> leftFields = Exprs.collect(equalTo.getLeft(), FieldAccess.class).stream()
                        .map(access -> access.toField()).collect(Collectors.toList());
                List<Field> rightFields = Exprs.collect(equalTo.getRight(), FieldAccess.class).stream()
                        .map(access -> access.toField()).collect(Collectors.toList());

                boolean leftMatchLeft = intersects(leftFields, leftSchema) && !intersects(leftFields, rightSchema);
                boolean rightMatchRight = intersects(rightFields, rightSchema) && !intersects(rightFields, leftSchema);
                if (leftMatchLeft && rightMatchRight) {
                    return true;
                }
                boolean leftMatchRight = intersects(leftFields, rightSchema) && !intersects(leftFields, leftSchema);
                boolean rightMatchLeft = intersects(rightFields, leftSchema) && !intersects(rightFields, rightSchema);
                if (leftMatchRight && rightMatchLeft) {
                    needExchange = true;
                    return true;
                }
            }
            return false;
        }

        private LogicExpr simplify(LogicExpr expr, List<LogicExpr> simplifiedExprs) {
            if (expr instanceof And) {
                And and = (And) expr;
                LogicExpr left = simplify(and.getLeft(), simplifiedExprs);
                LogicExpr right = simplify(and.getRight(), simplifiedExprs);
                if (left != null) {
                    if (right != null) {
                        return and;
                    } else {
                        return left;
                    }
                } else {
                    if (right != null) {
                        return right;
                    } else {
                        return null;
                    }
                }
            } else if (expr instanceof Or || expr instanceof PredicateExpr) {
                for (LogicExpr simplified : simplifiedExprs) {
                    if (simplified.fastEqual(expr)) {
                        return null;
                    }
                }
                return expr;
            }
            throw new IllegalArgumentException("Unknown LogicExpr " + expr);

        }

        private boolean intersects(List<Field> fields, StructType schema) {
            for (Field field : fields) {
                if (schema.getField(field.getFieldName()) != null) {
                    return true;
                }
            }
            return false;
        }

    }

}
