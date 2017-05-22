package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.logical.UnaryLogicalPlan;

public abstract class UnaryOperator<T extends UnaryLogicalPlan> extends AbstractStreamOperator<T> {

    protected final Operator child;

    public UnaryOperator(Operator child, T logicalPlan) {
        super(logicalPlan);
        this.child = child;
    }

    @Override
    public Operator[] children() {
        return new Operator[] { child };
    }

}
