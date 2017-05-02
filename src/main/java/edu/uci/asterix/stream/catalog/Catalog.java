package edu.uci.asterix.stream.catalog;

import java.util.HashMap;
import java.util.Map;

import edu.uci.asterix.stream.func.Function;

/**
 * A catalog contains a set of tables
 * for simplicity, schema is omitted here
 * 
 * @author luochen
 */
public class Catalog {
    public static final Catalog INSTANCE = new Catalog();

    private Map<String, Table> tableMap = new HashMap<>();

    private Map<String, Function> functionMap = new HashMap<>();

    private Catalog() {

    }

    public Table getTable(String name) {
        return tableMap.get(name);
    }

    public void addTable(Table table) throws CatalogException {
        if (getTable(table.getTableName()) != null) {
            throw new CatalogException("Table " + table.getTableName() + " already exists.");
        }
        tableMap.put(table.getTableName(), table);
    }

    public Function getFunction(String name) {
        return functionMap.get(name);
    }

    public void addFunction(Function function) throws CatalogException {
        if (getFunction(function.getName()) != null) {
            throw new CatalogException("Function " + function.getName() + " already exists.");
        }
        functionMap.put(function.getName(), function);
    }

}