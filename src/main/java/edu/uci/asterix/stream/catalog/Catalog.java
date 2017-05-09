package edu.uci.asterix.stream.catalog;

import java.util.HashMap;
import java.util.Map;

import edu.uci.asterix.stream.field.ArrayType;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;
import edu.uci.asterix.stream.func.Function;

/**
 * A catalog contains a set of tables
 * for simplicity, schema is omitted here
 * 
 * @author luochen
 */
public class Catalog {
    public static final Catalog INSTANCE = new Catalog();
    static {
        try {
            registerTables();
        } catch (CatalogException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private Map<String, TableImpl> tableMap = new HashMap<>();

    private Map<String, Function> functionMap = new HashMap<>();

    private Catalog() {

    }

    public TableImpl getTable(String name) {
        return tableMap.get(name);
    }

    public void addTable(TableImpl table) throws CatalogException {
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

    private static void registerTables() throws CatalogException {
        //building and user data
        TableImpl group = new TableImpl("Group");
        group.addField(new Field("id", PrimitiveType.get(FieldTypeName.STRING)));
        group.addField(new Field("name", PrimitiveType.get(FieldTypeName.STRING)));
        group.addField(new Field("description", PrimitiveType.get(FieldTypeName.STRING)));
        Catalog.INSTANCE.addTable(group);

        TableImpl user = new TableImpl("User");
        user.addField(new Field("email", PrimitiveType.get(FieldTypeName.STRING)));
        user.addField(new Field("string", PrimitiveType.get(FieldTypeName.STRING)));
        user.addField(new Field("groups", new ArrayType(group.getSchema())));
        Catalog.INSTANCE.addTable(user);

        TableImpl location = new TableImpl("Location");
        location.addField(new Field("x", PrimitiveType.get(FieldTypeName.REAL)));
        location.addField(new Field("y", PrimitiveType.get(FieldTypeName.REAL)));
        location.addField(new Field("z", PrimitiveType.get(FieldTypeName.REAL)));
        Catalog.INSTANCE.addTable(location);

        TableImpl region = new TableImpl("Region");
        region.addField(new Field("id", PrimitiveType.get(FieldTypeName.STRING)));
        region.addField(new Field("name", PrimitiveType.get(FieldTypeName.STRING)));
        region.addField(new Field("floor", PrimitiveType.get(FieldTypeName.INTEGER)));
        region.addField(new Field("geometry", new ArrayType(location.getSchema())));
        Catalog.INSTANCE.addTable(region);

        TableImpl infrastructureType = new TableImpl("InfrastructureType");
        infrastructureType.addField(new Field("id", PrimitiveType.get(FieldTypeName.STRING)));
        infrastructureType.addField(new Field("name", PrimitiveType.get(FieldTypeName.STRING)));
        infrastructureType.addField(new Field("description", PrimitiveType.get(FieldTypeName.STRING)));
        Catalog.INSTANCE.addTable(infrastructureType);

        TableImpl infrastructure = new TableImpl("Infrastructure");
        infrastructure.addField(new Field("id", PrimitiveType.get(FieldTypeName.STRING)));
        infrastructure.addField(new Field("name", PrimitiveType.get(FieldTypeName.STRING)));
        infrastructure.addField(new Field("type", infrastructureType.getSchema()));
        infrastructure.addField(new Field("region", region.getSchema()));
        Catalog.INSTANCE.addTable(infrastructure);

        //devices
        TableImpl platformType = new TableImpl("PlatformType");
        platformType.addField(new Field("id", PrimitiveType.get(FieldTypeName.STRING)));
        platformType.addField(new Field("name", PrimitiveType.get(FieldTypeName.STRING)));
        platformType.addField(new Field("description", PrimitiveType.get(FieldTypeName.STRING)));
        Catalog.INSTANCE.addTable(platformType);

        TableImpl platform = new TableImpl("Platform");
        platform.addField(new Field("id", PrimitiveType.get(FieldTypeName.STRING)));
        platform.addField(new Field("name", PrimitiveType.get(FieldTypeName.STRING)));
        platform.addField(new Field("description", PrimitiveType.get(FieldTypeName.STRING)));
        platform.addField(new Field("type", platformType.getSchema()));
        platform.addField(new Field("location", location.getSchema()));
        platform.addField(new Field("owner", user.getSchema()));
        Catalog.INSTANCE.addTable(platform);

        //sensors and observations
        TableImpl sensorType = new TableImpl("SensorType");
        sensorType.addField(new Field("id", PrimitiveType.get(FieldTypeName.STRING)));
        sensorType.addField(new Field("name", PrimitiveType.get(FieldTypeName.STRING)));
        sensorType.addField(new Field("description", PrimitiveType.get(FieldTypeName.STRING)));
        sensorType.addField(new Field("mobility", platformType.getSchema()));
        sensorType.addField(new Field("payloadSchema", PrimitiveType.get(FieldTypeName.STRING)));
        Catalog.INSTANCE.addTable(sensorType);

        TableImpl sensor = new TableImpl("Sensor");
        sensor.addField(new Field("id", PrimitiveType.get(FieldTypeName.STRING)));
        sensor.addField(new Field("name", PrimitiveType.get(FieldTypeName.STRING)));
        sensor.addField(new Field("description", PrimitiveType.get(FieldTypeName.STRING)));
        sensor.addField(new Field("type", sensorType.getSchema()));
        sensor.addField(new Field("location", location.getSchema()));
        sensor.addField(new Field("platform", platform.getSchema()));
        sensor.addField(new Field("user", user.getSchema()));
        sensor.addField(new Field("coverageRooms", new ArrayType(infrastructure.getSchema())));
        sensor.addField(new Field("mac", PrimitiveType.get(FieldTypeName.STRING)));
        sensor.addField(new Field("IP", PrimitiveType.get(FieldTypeName.STRING)));
        sensor.addField(new Field("port", PrimitiveType.get(FieldTypeName.STRING)));
        Catalog.INSTANCE.addTable(sensor);

        TableImpl observationType = new TableImpl("ObservationType");
        observationType.addField(new Field("id", PrimitiveType.get(FieldTypeName.STRING)));
        observationType.addField(new Field("name", PrimitiveType.get(FieldTypeName.STRING)));
        observationType.addField(new Field("description", PrimitiveType.get(FieldTypeName.STRING)));
        observationType.addField(new Field("payloadSchema", PrimitiveType.get(FieldTypeName.STRING)));
        Catalog.INSTANCE.addTable(observationType);

        TableImpl observation = new TableImpl("Observation");
        observation.addField(new Field("id", PrimitiveType.get(FieldTypeName.STRING)));
        observation.addField(new Field("sensor", sensor.getSchema()));
        observation.addField(new Field("timestamp", PrimitiveType.get(FieldTypeName.STRING)));
        observation.addField(new Field("payload", location.getSchema()));
        observation.addField(new Field("type", observationType.getSchema()));
        Catalog.INSTANCE.addTable(observation);

    }

}