package edu.uci.asterix.stream.catalog;

import java.util.List;

import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;

public interface Table {
    public String getTableName();

    public List<Field> getFields();

    public Field getField(String name);

    public void addField(Field field) throws CatalogException;

    public StructType getSchema();
}
