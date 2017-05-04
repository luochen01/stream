package edu.uci.asterix.stream.logical;

public abstract class LeafLogicalPlan extends LogicalPlan {

    @Override
    public LogicalPlan[] children() {
        return new LogicalPlan[0];
    }

}
