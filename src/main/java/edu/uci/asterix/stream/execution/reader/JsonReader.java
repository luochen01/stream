package edu.uci.asterix.stream.execution.reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.ArrayType;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.StructType;

public class JsonReader extends AbstractTupleReader {
    private final static Logger LOGGER = LoggerFactory.getLogger(JsonReader.class);

    private Iterator iterator;

    public JsonReader(StructType sourceSchema, StructType outputSchema, InputStream input)
            throws IOException, ParseException {
        super(sourceSchema, outputSchema, input);
        JSONParser parser = new JSONParser();
        JSONObject table = (JSONObject) parser.parse(new InputStreamReader(input));
        JSONArray rows = (JSONArray) table.get("rows");
        iterator = rows.iterator();
    }

    @Override
    public Tuple nextTuple() {
        while (iterator != null && iterator.hasNext()) {
            JSONObject row = (JSONObject) iterator.next();
            Tuple tuple = parseStruct(row, sourceSchema);
            tuple.setSchema(outputSchema);
            return tuple;
        }
        return null;
    }

    private Object parseJson(Object jsonObj, FieldType type, String fieldName) {
        if (jsonObj == null) {
            return null;
        }
        FieldTypeName typeName = type.getFieldTypeName();
        try {
            switch (typeName) {
                case BOOLEAN:
                case INTEGER:
                case STRING:
                case REAL:
                    return parsePrimitive(jsonObj, type);
                case ARRAY:
                    return parseArray((JSONArray) jsonObj, (ArrayType) type, fieldName);
                case STRUCT:
                    return parseStruct((JSONObject) jsonObj, (StructType) type);
            }
        } catch (Exception e) {
            LOGGER.error("Ignored illegal value {} for field {}", jsonObj, fieldName);
            return null;
        }
        throw new UnsupportedOperationException("Unknown type " + typeName);
    }

    private Object[] parseArray(JSONArray jsonArray, ArrayType arrayType, String fieldName) {
        Object[] values = new Object[jsonArray.size()];
        FieldType elementType = arrayType.getElementType();
        int i = 0;
        for (Object jsonObj : jsonArray) {
            values[i++] = parseJson(jsonObj, elementType, fieldName);
        }
        return values;
    }

    private Tuple parseStruct(JSONObject jsonObj, StructType structType) {
        Object[] values = new Object[structType.getFieldCount()];
        List<Field> fields = structType.getFields();
        for (int i = 0; i < values.length; i++) {
            Field field = fields.get(i);
            Object obj = jsonObj.get(field.getFieldName());
            values[i] = parseJson(obj, field.getFieldType(), field.getFieldName());
        }
        return new Tuple(structType, values);

    }

    private Object parsePrimitive(Object value, FieldType type) {
        if (value == null) {
            return null;
        }
        switch (type.getFieldTypeName()) {
            case BOOLEAN:
                if (!(value instanceof Boolean)) {
                    throw new IllegalArgumentException();
                }
                return value;
            case INTEGER:
                if (!(value instanceof Number)) {
                    throw new IllegalArgumentException();
                }
                return ((Number) value).intValue();
            case REAL:
                if (!(value instanceof Number)) {
                    throw new IllegalArgumentException();
                }
                return ((Number) value).doubleValue();
            case STRING:
                return value.toString();
            default:
                throw new UnsupportedOperationException("Unknown primitive type " + type);
        }
    }

    @Override
    public void close() throws IOException {
        super.close();
        this.iterator = null;
    }

}
