package edu.uci.asterix.stream.catalog;

import java.util.List;

import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.RelOptTable.ToRelContext;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.type.RelDataTypeField;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.util.Source;

import edu.uci.asterix.stream.execution.rules.RelationTableScan;

public class RelationTable extends BaseTable{

    public RelationTable(StreamSchema schema, String tableName, Source source, List<RelDataTypeField> fields) {
        super(schema, tableName, Schema.TableType.TABLE, source, fields);
    }

    @Override
    public RelNode toRel(ToRelContext context, RelOptTable relOptTable) {
        return new RelationTableScan(context.getCluster(), relOptTable, this);
    }

}
