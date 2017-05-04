package edu.uci.asterix.stream.logical;

import edu.uci.asterix.stream.field.StructType;

public class LogicalLimit extends UnaryLogicalPlan {

    protected final int limit;

    protected final int offset;

    public LogicalLimit(LogicalPlan child, int limit, int offset) {
        super(child);
        this.limit = limit;
        this.offset = offset;
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
        sb.append("offset:");
        sb.append(offset);

    }

}
