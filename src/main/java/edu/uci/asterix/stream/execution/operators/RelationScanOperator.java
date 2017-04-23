package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.catalog.RelationTable;
import edu.uci.asterix.stream.execution.ITuple;

public class RelationScanOperator extends LeafStreamOperator<RelationTable> {

    public RelationScanOperator(RelationTable table) {
        super(table);

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public ITuple next() {
        return null;
    }

}
