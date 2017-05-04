package edu.uci.asterix.stream.logical;

import java.util.ArrayList;
import java.util.List;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.pred.LogicExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.utils.Utils;

public class LogicalGroupby extends UnaryLogicalPlan {

    private final List<Expr> byFields;
    private final List<Expr> aggregateExprs;
    private final LogicExpr havingCondition;
    private final StructType schema;

    public LogicalGroupby(LogicalPlan child, List<Expr> byFields, List<Expr> aggregateExprs,
            LogicExpr havingCondition) {
        super(child);

        this.byFields = byFields;
        this.aggregateExprs = aggregateExprs;
        this.havingCondition = havingCondition;

        List<Field> fields = new ArrayList<>();
        byFields.forEach(by -> fields.add(by.toField()));
        aggregateExprs.forEach(aggr -> fields.add(aggr.toField()));

        this.schema = new StructType(fields);
    }

    @Override
    public StructType getSchema() {
        return schema;
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(Utils.format(byFields, ","));
        sb.append("\t");
        sb.append(Utils.format(aggregateExprs, ","));
        sb.append("\t");
        sb.append(havingCondition);
    }

    @Override
    public String getName() {
        return "GROUPBY";
    }

}
