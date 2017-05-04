package edu.uci.asterix.stream.logical;

public abstract class BinaryLogicalPlan extends LogicalPlan {
    protected final LogicalPlan left;

    protected final LogicalPlan right;

    public BinaryLogicalPlan(LogicalPlan left, LogicalPlan right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public LogicalPlan[] children() {
        return new LogicalPlan[] { left, right };
    }

}
