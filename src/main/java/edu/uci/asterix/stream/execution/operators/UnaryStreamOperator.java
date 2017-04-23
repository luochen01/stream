package edu.uci.asterix.stream.execution.operators;

public abstract class UnaryStreamOperator extends AbstractStreamOperator {

    protected final IStreamOperator child;

    public UnaryStreamOperator(IStreamOperator child) {
        this.child = child;
    }
}
