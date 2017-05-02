package edu.uci.asterix.stream.logical;

import edu.uci.asterix.stream.expr.Window;
import edu.uci.asterix.stream.field.StructType;

public class LogicalStream extends UnaryLogicalPlan {

    protected final Window window;

    public LogicalStream(LogicalPlan child, Window window) {
        super(child);
        this.window = window;
    }

    @Override
    public StructType getSchema() {
        //TODO
        return null;
    }
}
