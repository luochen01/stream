package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Window;
import edu.uci.asterix.stream.field.StructType;

public class StreamOperator extends UnaryOperator {

    protected final Window window;

    public StreamOperator(Operator child, Window window) {
        super(child);
        this.window = window;
    }

    @Override
    public StructType getSchema() {
        //TODO implement
        return null;
    }

    @Override
    protected Tuple nextImpl() {
        //TODO implement
        return null;
    }

}
