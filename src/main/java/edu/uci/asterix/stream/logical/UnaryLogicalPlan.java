package edu.uci.asterix.stream.logical;

public abstract class UnaryLogicalPlan extends LogicalPlan {

    protected final LogicalPlan child;

    public UnaryLogicalPlan(LogicalPlan child) {
        this.child = child;
    }

    @Override
    public LogicalPlan[] children() {
        return new LogicalPlan[] { child };
    }

    public LogicalPlan getChild() {
        return child;
    }

}
