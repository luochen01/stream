package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;

public abstract class AbstractStreamOperator implements Operator {

    protected boolean closed = false;

    @Override
    public Tuple next() {
        if (closed) {
            return null;
        }
        return nextImpl();
    }

    protected abstract Tuple nextImpl();

}
