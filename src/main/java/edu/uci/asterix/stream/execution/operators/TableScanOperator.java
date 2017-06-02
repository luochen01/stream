package edu.uci.asterix.stream.execution.operators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import edu.uci.asterix.stream.catalog.TableImpl;
import edu.uci.asterix.stream.exception.StreamExecutionException;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.reader.ITupleReader;
import edu.uci.asterix.stream.execution.reader.TupleReaderProvider;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalTableScan;

public class TableScanOperator extends AbstractStreamOperator<LogicalTableScan> {

    private final TableImpl table;

    private final StructType schema;

    private ITupleReader reader;

    public TableScanOperator(LogicalTableScan logicalScan) {
        super(logicalScan);
        this.table = logicalScan.getTable();
        this.schema = table.getSchema();
    }

    @Override
    public Tuple next() {
        Tuple tuple = reader.nextTuple();
        if (tuple == null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tuple;
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

    @Override
    public void initialize() {
        try {
            InputStream input = new FileInputStream(table.getTablePath());
            reader = TupleReaderProvider.INSTANCE.create(table.getFormat(), schema, input);
        } catch (Exception e) {
            throw new StreamExecutionException("Failed to open table file " + table.getTablePath(), e);
        }
    }

    @Override
    public void reset() {
        super.reset();
        reader = null;

    }

}
