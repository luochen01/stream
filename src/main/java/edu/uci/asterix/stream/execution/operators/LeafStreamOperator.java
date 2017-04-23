package edu.uci.asterix.stream.execution.operators;

import org.apache.calcite.rel.type.RelDataType;

import edu.uci.asterix.stream.catalog.BaseTable;
import edu.uci.asterix.stream.global.StreamGlobal;

public abstract class LeafStreamOperator<T extends BaseTable> extends AbstractStreamOperator {

    protected final T table;

    public LeafStreamOperator(T table) {
        this.table = table;
    }

    @Override
    public RelDataType getFields() {
        return table.getRowType(StreamGlobal.DEFAULT_TYPE_FACTORY);
    }
}
