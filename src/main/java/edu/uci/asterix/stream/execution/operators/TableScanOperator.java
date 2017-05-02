package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.catalog.Table;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.StructType;

public class TableScanOperator extends LeafOperator {

    private final Table table;

    public TableScanOperator(Table table) {
        this.table = table;

    }

    @Override
    public StructType getSchema() {
        return table.getSchema();
    }

    @Override
    protected Tuple nextImpl() {

        //TODO impl
        throw new UnsupportedOperationException();
    }

}
