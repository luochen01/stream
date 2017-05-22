package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalPlan;

public abstract class AbstractStreamOperator<T extends LogicalPlan> implements Operator {

    protected final T logicalPlan;

    public AbstractStreamOperator(T logicalPlan) {
        this.logicalPlan = logicalPlan;
    }

    @Override
    public StructType getSchema() {
        return logicalPlan.getSchema();
    }

    @Override
    public LogicalPlan getLogicalPlan() {
        return logicalPlan;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        print(sb, 0);
        return sb.toString();
    }

    @Override
    public void print(StringBuilder sb, int level) {
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        sb.append(getName());
        sb.append(":");
        printContent(sb);
        sb.append("\n");
        for (Operator child : children()) {
            child.print(sb, level + 1);
        }
    }

    @Override
    public void reset() {
        for (Operator child : children()) {
            child.reset();
        }
    }

    @Override
    public void initialize() {
        for (Operator child : children()) {
            child.initialize();
        }
    }

    protected abstract void printContent(StringBuilder sb);

}
