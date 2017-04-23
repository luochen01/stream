package edu.uci.asterix.stream.execution.operators;

public abstract class BinaryStreamOperator extends AbstractStreamOperator {
    protected final IStreamOperator left;

    protected final IStreamOperator right;

    public BinaryStreamOperator(IStreamOperator left, IStreamOperator right) {
        this.left = left;
        this.right = right;
    }

}
