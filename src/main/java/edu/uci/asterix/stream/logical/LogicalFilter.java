package edu.uci.asterix.stream.logical;

import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.field.StructType;

public class LogicalFilter extends UnaryLogicalPlan {

    protected final LogicExpr condition;

    public LogicalFilter(LogicalPlan child, LogicExpr condition) {
        super(child);
        this.condition = condition;
    }

    @Override
    public String getName() {
        return "FILTER";
    }

    @Override
    public StructType getSchema() {
        return child.getSchema();
    }

    public LogicExpr getCondition() {
        return condition;
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(condition.toString());
    }

}
