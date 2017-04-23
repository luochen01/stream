package edu.uci.asterix.stream.catalog;

import java.util.List;

import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.RelOptTable.ToRelContext;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataTypeField;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.StreamableTable;
import org.apache.calcite.schema.Table;
import org.apache.calcite.util.Source;

import edu.uci.asterix.stream.execution.rules.StreamTableScan;

public class StreamTable extends BaseTable implements StreamableTable {

    public StreamTable(StreamSchema schema, String tableName, Source source, List<RelDataTypeField> fields) {
        super(schema, tableName, Schema.TableType.STREAM, source, fields);
    }

    @Override
    public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        return typeFactory.createStructType(fields);
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public Table stream() {
        return this;
    }

    @Override
    public RelNode toRel(ToRelContext context, RelOptTable relOptTable) {
        return new StreamTableScan(context.getCluster(), relOptTable, this);
    }

}
