package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.logical.BinaryLogicalPlan;

public abstract class BinaryOperator<T extends BinaryLogicalPlan> extends AbstractStreamOperator<T> {
    protected final Operator left;

    protected final Operator right;

    public BinaryOperator(Operator left, Operator right, T logicalPlan) {
        super(logicalPlan);
        this.left = left;
        this.right = right;
    }

    @Override
    public Operator[] children() {
        return new Operator[] { left, right };
    }

}
