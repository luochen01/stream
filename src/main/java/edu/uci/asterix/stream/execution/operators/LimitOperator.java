package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.StructType;

public class LimitOperator extends UnaryOperator {

    protected final int limit;

    protected final int offset;

    public LimitOperator(Operator child, int limit, int offset) {
        super(child);
        this.limit = limit;
        this.offset = offset;
    }

    @Override
    public StructType getSchema() {
        return child.getSchema();
    }

    @Override
    protected Tuple nextImpl() {
        //TODO
        return null;
    }

}
