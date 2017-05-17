package edu.uci.asterix.stream.catalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalPlan;

public class TableImpl implements Table {

    private final String tableName;



    private String tablePath;

    private final List<Field> fields = new ArrayList<>();

    private final Map<String, Field> fieldMap = new HashMap<>();

    public TableImpl(String tableName) {
        this.tableName = tableName;
    }
    public void setTablePath(String tablePath) {
        this.tablePath = tablePath;
    }
    public String getTableName() {
        return tableName;
    }

    public String getTablePath() {
        return tablePath;
    }

    @Override
    public LogicalPlan getLogicalPlan() {
        return null;
    }

    public List<Field> getFields() {
        return fields;
    }

    public Field getField(String name) {
        return fieldMap.get(name);
    }

    public void addField(Field field) throws CatalogException {
        if (getField(field.getFieldName()) != null) {
            throw new CatalogException("Field " + field.getFieldName() + " already exists in table " + tableName);
        }
        fields.add(field);
        fieldMap.put(field.getFieldName(), field);
    }

    public StructType getSchema() {
        return new StructType(fields);
    }
}
