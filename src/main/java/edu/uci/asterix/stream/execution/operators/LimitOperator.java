package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalLimit;

public class LimitOperator extends UnaryOperator<LogicalLimit> {

    protected final int limit;

    protected final int offset;

    private int position = 0;

    private int count = 0;

    public LimitOperator(Operator child, LogicalLimit logicalLimit) {
        super(child, logicalLimit);
        this.limit = logicalLimit.getLimit();
        this.offset = logicalLimit.getOffset();
    }

    @Override
    public StructType getSchema() {
        return child.getSchema();
    }

    @Override
    public String getName() {
        return "LIMIT";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(limit);
        sb.append(",");
        sb.append("OFFSET");
        sb.append(offset);
    }

    @Override
    public Tuple next() {
        Tuple tuple = child.next();
        if (count < limit && tuple!=null) {
            count++;
            return tuple;
        }
        return null;
    }

    @Override
    public void initialize() {
        super.initialize();
        this.position = 0;
        this.count = 0;
        Tuple tuple;
        if (offset >=0 && limit>= 0) {
            while (position < offset) {
                position++;
                tuple = child.next();

            }
        }
        else throw  new UnsupportedOperationException();
    }

    @Override
    public void reset() {
        super.reset();
        this.position = 0;
        this.count = 0;
    }

}
