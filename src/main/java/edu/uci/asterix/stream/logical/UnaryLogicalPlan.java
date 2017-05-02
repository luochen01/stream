package edu.uci.asterix.stream.logical;

public abstract class UnaryLogicalPlan extends LogicalPlan {

    protected final LogicalPlan child;

    public UnaryLogicalPlan(LogicalPlan child) {
        this.child = child;
    }

}
