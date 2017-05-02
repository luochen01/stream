package edu.uci.asterix.stream.execution.operators;

public abstract class BinaryOperator extends AbstractStreamOperator {
    protected final Operator left;

    protected final Operator right;

    public BinaryOperator(Operator left, Operator right) {
        this.left = left;
        this.right = right;
    }

}
