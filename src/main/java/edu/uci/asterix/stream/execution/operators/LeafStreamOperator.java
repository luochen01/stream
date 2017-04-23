package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.catalog.StreamTable;

public abstract class LeafStreamOperator extends AbstractStreamOperator {

    protected final StreamTable table;

    public LeafStreamOperator(StreamTable table) {
        this.table = table;
    }
}
