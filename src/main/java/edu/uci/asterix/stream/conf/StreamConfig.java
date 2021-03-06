package edu.uci.asterix.stream.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamConfig {
    private static final String Case_Sensitive = "case.sensitive";

    private static final String Stream_Sensor_Id_Field = "stream.sensor.id.field";

    private static final String Stream_Time_Field = "stream.time.field";

    private static final String Stream_Time_Format = "stream.time.format";

    private static final String Stream_Table_Name = "stream.table.name";

    private static final String Sensor_Id_Field = "sensor.id.field";

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamConfig.class);

    public static final StreamConfig Instance = new StreamConfig();

    private final Properties properties;

    public StreamConfig() {
        this("stream.properties");

    }

    public StreamConfig(String path) {
        properties = new Properties();
        try {
            loadProperties(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadProperties(String path) throws IOException {
        InputStream input = openProperties(path);
        if (input != null) {
            properties.load(input);
        } else {
            LOGGER.warn("Couldn't find configuration file from {}", path);
        }
    }

    private InputStream openProperties(String path) throws IOException {
        InputStream input = getClass().getClassLoader().getResourceAsStream(path);
        if (input != null) {
            return input;
        }

        if (Files.exists(Paths.get(path))) {
            input = new FileInputStream(path);
        }
        return input;
    }

    public boolean caseSensitive() {
        return getBoolean(Case_Sensitive, false);
    }

    public String streamTimeField() {
        return getString(Stream_Time_Field, "timeStamp");
    }

    public String streamTimeFormat() {
        return getString(Stream_Time_Format, "yyyy-MM-dd HH:mm:ss");
    }

    public String streamSensorIdField() {
        return getString(Stream_Sensor_Id_Field, "sensor_id");
    }

    public String streamTableName() {
        return getString(Stream_Table_Name, "Observation");
    }

    public String sensorIdField() {
        return getString(Sensor_Id_Field, "id");
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return (boolean) get(key, defaultValue, boolean.class);
    }

    public int getInt(String key, int defaultValue) {
        return (int) get(key, defaultValue, int.class);
    }

    public double getBoolean(String key, double defaultValue) {
        return (double) get(key, defaultValue, boolean.class);
    }

    public float getFloat(String key, float defaultValue) {
        return (float) get(key, defaultValue, float.class);
    }

    public String getString(String key, String defaultValue) {
        return (String) get(key, defaultValue, String.class);
    }

    private Object get(String key, Object defaultValue, Class<?> type) {
        String value = properties.getProperty(key);
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        if (type == Integer.class) {
            return Integer.valueOf(value);
        } else if (type == boolean.class) {
            return Boolean.parseBoolean(value);
        } else if (type == int.class) {
            return Integer.parseInt(value);
        } else if (type == float.class) {
            return Float.parseFloat(value);
        } else if (type == double.class) {
            return Double.parseDouble(value);
        } else if (type == String.class) {
            return value;
        }
        throw new IllegalArgumentException("Unknown type " + type);

    }
}
