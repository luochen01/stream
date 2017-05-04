package edu.uci.asterix.stream.parser;

import java.util.List;

import edu.uci.asterix.stream.catalog.CatalogException;
import edu.uci.asterix.stream.catalog.Table;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalPlan;

public class SensorCollection implements Table {

    private final String name;

    private LogicalPlan plan;

    private StructType schema;

    public SensorCollection(String name) {
        this.name = name;
    }

    public String getTableName() {
        return name;
    }

    public LogicalPlan getLogicalPlan() {
        return plan;
    }

    public void setLogicalPlan(LogicalPlan plan) {
        this.plan = plan;
        this.schema = plan.getSchema();
    }

    public StructType getSchema() {
        return this.schema;
    }

    @Override
    public void addField(Field field) throws CatalogException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Field getField(String name) {
        return this.schema.getField(name);
    }

    @Override
    public List<Field> getFields() {
        return this.schema.getFields();
    }

}
