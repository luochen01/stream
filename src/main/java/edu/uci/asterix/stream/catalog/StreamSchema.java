package edu.uci.asterix.stream.catalog;

import java.util.HashMap;
import java.util.Map;

import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaFactory;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.Table;
import org.apache.calcite.schema.impl.AbstractSchema;

/**
 * Extensible schema for our stream project
 * 
 * @author luochen
 */
public class StreamSchema extends AbstractSchema {
    private Map<String, Table> tableMap = new HashMap<String, Table>();
    private String name;

    public StreamSchema(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Map<String, Table> getTableMap() {
        return tableMap;
    }

    public void addTable(String name, Table table) throws CatalogException {
        if (tableMap.containsKey(name)) {
            throw new CatalogException("Table " + name + " already exists in Schema " + this.name);
        }
        tableMap.put(name, table);
    }

    public void removeTable(String name) throws CatalogException {
        if (tableMap.remove(name) == null) {
            throw new CatalogException("Table " + name + " not exists in Schema " + this.name);
        }
    }

    public static class Factory implements SchemaFactory {
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        public Schema create(SchemaPlus parentSchema, String name, Map<String, Object> operand) {
            return new StreamSchema(name);
        }
    }
}