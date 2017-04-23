package edu.uci.asterix.stream.catalog;

import java.util.List;

import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.RelOptTable.ToRelContext;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataTypeField;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.Schema.TableType;
import org.apache.calcite.schema.TranslatableTable;
import org.apache.calcite.schema.impl.AbstractTable;
import org.apache.calcite.util.Source;

import edu.uci.asterix.stream.execution.rules.StreamTableScan;

public class StreamTable extends AbstractTable implements TranslatableTable {
    protected final StreamSchema schema;
    protected final String tableName;
    protected final Schema.TableType tableType;
    protected final Source source;

    protected final List<RelDataTypeField> fields;

    public StreamTable(StreamSchema schema, String tableName, TableType tableType, Source source,
            List<RelDataTypeField> fields) {
        this.schema = schema;
        this.tableName = tableName;
        this.tableType = tableType;
        this.source = source;
        this.fields = fields;
    }

    @Override
    public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.createStructType(fields);
    }

    public Schema.TableType getTableType() {
        return tableType;
    }

    @Override
    public RelNode toRel(ToRelContext context, RelOptTable relOptTable) {
        return new StreamTableScan(context.getCluster(), relOptTable, this);
    }

    public String getTableName() {
        return tableName;
    }

}
