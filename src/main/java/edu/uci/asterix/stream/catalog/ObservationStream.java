package edu.uci.asterix.stream.catalog;

import java.util.List;

import edu.uci.asterix.stream.conf.StreamConfig;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalPlan;
import edu.uci.asterix.stream.utils.Assertion;

public class ObservationStream implements Table {
    private final String name;
    private SensorCollection collection;
    private final StructType schema;

    public ObservationStream(String name) {
        this.name = name;
        TableImpl streamTable = Catalog.INSTANCE.getTable(StreamConfig.Instance.streamTableName());

        Assertion.asserts(streamTable != null,
                "Stream schema is not found for " + StreamConfig.Instance.streamTableName());
        this.schema = streamTable.getSchema();

    }

    public SensorCollection getSensorCollection() {
        return collection;
    }

    public void setSensorCollection(SensorCollection collection) {
        this.collection = collection;
    }

    @Override
    public String getTableName() {
        return name;
    }

    @Override
    public List<Field> getFields() {
        return schema.getFields();

    }

    @Override
    public Field getField(String name) {
        return schema.getField(name);
    }

    @Override
    public void addField(Field field) throws CatalogException {
        throw new UnsupportedOperationException();
    }

    @Override
    public StructType getSchema() {
        return schema;
    }

    @Override
    public LogicalPlan getLogicalPlan() {
        return collection.getLogicalPlan();
    }

}
