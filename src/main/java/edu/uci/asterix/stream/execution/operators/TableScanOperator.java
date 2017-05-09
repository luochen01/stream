package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.catalog.TableImpl;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.logical.LogicalTableScan;

public class TableScanOperator extends AbstractStreamOperator<LogicalTableScan> {

    private final TableImpl table;

    public TableScanOperator(LogicalTableScan logicalScan) {
        super(logicalScan);
        this.table = logicalScan.getTable();
    }

    @Override
    protected Tuple nextImpl() {

        //TODO impl
        throw new UnsupportedOperationException();
    }

    @Override
    public Operator[] children() {
        return new Operator[0];
    }

    @Override
    public String getName() {
        return "TABLE";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(table.getTableName());
        if (!logicalPlan.getAlias().equals(table.getTableName())) {
            sb.append(" AS ");
            sb.append(logicalPlan.getAlias());
        }
    }

}
