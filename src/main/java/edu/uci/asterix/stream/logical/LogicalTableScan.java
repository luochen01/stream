package edu.uci.asterix.stream.logical;

import java.util.List;
import java.util.stream.Collectors;

import edu.uci.asterix.stream.catalog.Table;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;

public class LogicalTableScan extends LeafLogicalPlan {

    private final Table table;

    private final String tableAlias;

    private final StructType schema;

    public LogicalTableScan(Table table, String tableAlias) {
        this.table = table;
        this.tableAlias = tableAlias;
        List<Field> fields = table.getFields().stream().map(field -> field.withTableAlias(tableAlias))
                .collect(Collectors.toList());
        schema = new StructType(fields);
    }

    @Override
    public StructType getSchema() {
        return schema;
    }

    @Override
    public String getName() {
        return "TABLE";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(table.getTableName());
    }

}
