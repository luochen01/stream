package edu.uci.asterix.stream.logical;

import java.util.List;
import java.util.stream.Collectors;

import edu.uci.asterix.stream.catalog.Table;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;

public abstract class LogicalScan<T extends Table> extends LogicalPlan {

    private final T table;

    private final String alias;

    private final StructType schema;

    public LogicalScan(T table, String alias) {
        this.table = table;
        this.alias = alias;
        List<Field> fields = table.getFields().stream().map(field -> field.withTableAlias(alias))
                .collect(Collectors.toList());
        schema = new StructType(fields);
    }

    public T getTable() {
        return table;
    }

    @Override
    public LogicalPlan[] children() {
        return new LogicalPlan[0];
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public StructType getSchema() {
        return schema;
    }

    @Override
    protected void printContent(StringBuilder sb, int level) {
        sb.append(table.getTableName());
        if (!alias.equals(table.getTableName())) {
            sb.append(" AS ");
            sb.append(alias);
        }
        if (table.getLogicalPlan() != null) {
            sb.append("\n");
            table.getLogicalPlan().print(sb, level + 1);
        }
    }

}
