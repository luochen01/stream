package edu.uci.asterix.stream.logical;

import edu.uci.asterix.stream.expr.pred.PredicateExpr;
import edu.uci.asterix.stream.field.StructType;

public class LogicalFilter extends UnaryLogicalPlan {

    protected final PredicateExpr condition;

    public LogicalFilter(LogicalPlan child, PredicateExpr condition) {
        super(child);
        this.condition = condition;
    }

    @Override
    public StructType getSchema() {
        return child.getSchema();
    }

    public PredicateExpr getCondition() {
        return condition;
    }

}
