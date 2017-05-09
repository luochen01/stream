package edu.uci.asterix.stream.logical;

import edu.uci.asterix.stream.field.StructType;

public abstract class LogicalPlan {

    public abstract StructType getSchema();

    public abstract String getName();

    public abstract LogicalPlan[] children();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        print(sb, 0);
        return sb.toString();
    }

    public void print(StringBuilder sb, int level) {
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        sb.append(getName());
        sb.append(":");
        printContent(sb, level);
        sb.append("\n");
        for (LogicalPlan child : children()) {
            child.print(sb, level + 1);
        }
    }

    protected abstract void printContent(StringBuilder sb, int level);

}
