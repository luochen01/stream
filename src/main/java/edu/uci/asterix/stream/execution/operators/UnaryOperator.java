package edu.uci.asterix.stream.execution.operators;

public abstract class UnaryOperator extends AbstractStreamOperator {

    protected final Operator child;

    public UnaryOperator(Operator child) {
        this.child = child;
    }
}
