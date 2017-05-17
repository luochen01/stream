package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalLimit;

public class LimitOperator extends UnaryOperator<LogicalLimit> {

    protected final int limit;

    protected final int offset;

    private static int position = 0;
    private static int count = 0;

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
        // TODO Auto-generated method stub
        Tuple tuple = null;

        while(position < offset)
        {
            position++;
            tuple = child.next();

        }
        while(count < limit)
        {
            tuple = child.next();
            count++;
            return tuple;
        }

        return null;
    }

}
