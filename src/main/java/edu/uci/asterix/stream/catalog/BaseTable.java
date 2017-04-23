package edu.uci.asterix.stream.catalog;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.calcite.linq4j.QueryProvider;
import org.apache.calcite.linq4j.Queryable;
import org.apache.calcite.linq4j.tree.Expression;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataTypeField;
import org.apache.calcite.schema.QueryableTable;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.Schema.TableType;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.Schemas;
import org.apache.calcite.schema.TranslatableTable;
import org.apache.calcite.schema.impl.AbstractTable;
import org.apache.calcite.util.Source;

import edu.uci.asterix.stream.execution.ITuple;

public abstract class BaseTable extends AbstractTable implements TranslatableTable, QueryableTable {
    protected final StreamSchema schema;
    protected final String tableName;
    protected final Schema.TableType tableType;
    protected final Source source;

    protected final List<RelDataTypeField> fields;

    public BaseTable(StreamSchema schema, String tableName, TableType tableType, Source source,
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

    public String getTableName() {
        return tableName;
    }

    @Override
    public <T> Queryable<T> asQueryable(QueryProvider queryProvider, SchemaPlus schema, String tableName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Type getElementType() {
        return ITuple.class;
    }

    @Override
    public Expression getExpression(SchemaPlus schema, String tableName, Class clazz) {
        return Schemas.tableExpression(schema, getElementType(), tableName, clazz);
    }

}
