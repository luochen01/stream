package edu.uci.asterix.stream.logical;

import edu.uci.asterix.stream.catalog.TableImpl;

public class LogicalTableScan extends LogicalScan<TableImpl> {

    public LogicalTableScan(TableImpl table, String alias) {
        super(table, alias);
    }

    @Override
    public String getName() {
        return "Table";
    }

}
