package edu.uci.asterix.stream.parser;

import java.util.List;

import edu.uci.asterix.stream.catalog.CatalogException;
import edu.uci.asterix.stream.catalog.Table;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;

public class ObservationStream implements Table {
    private String name;
    private SensorCollection collection;
    private StructType schema;

    public ObservationStream(String name) {
        this.name = name;
    }

    public SensorCollection getSensorCollection() {
        return collection;
    }

    public void setSensorCollection(SensorCollection collection) {
        this.collection = collection;
        this.schema = collection.getSchema();
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

}
