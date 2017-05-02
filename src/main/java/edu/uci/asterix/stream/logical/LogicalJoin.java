package edu.uci.asterix.stream.logical;

import edu.uci.asterix.stream.expr.pred.PredicateExpr;
import edu.uci.asterix.stream.field.StructType;

public class LogicalJoin extends BinaryLogicalPlan {

    protected PredicateExpr condition;

    public LogicalJoin(LogicalPlan left, LogicalPlan right, PredicateExpr condition) {
        super(left, right);
        this.condition = condition;
    }

    @Override
    public StructType getSchema() {
        //TODO
        return null;
    }

}
