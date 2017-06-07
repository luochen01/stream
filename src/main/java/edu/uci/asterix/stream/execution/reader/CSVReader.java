package edu.uci.asterix.stream.execution.reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.StructType;

public class CSVReader extends AbstractTupleReader {
    private final static Logger LOGGER = LoggerFactory.getLogger(CSVReader.class);

    private Iterator<CSVRecord> iterator;
    private CSVParser parser;

    private final JSONParser jsonParser;

    public CSVReader(StructType sourceSchema, StructType outputSchema, InputStream input) throws IOException {
        super(sourceSchema, outputSchema, input);
        parser = CSVFormat.DEFAULT.withHeader().parse(new InputStreamReader(input));
        jsonParser = new JSONParser();
        iterator = parser.iterator();

    }

    @Override
    public Tuple nextTuple() {
        while (iterator != null && iterator.hasNext()) {
            return parseCSVRecord(iterator.next());
        }
        return null;
    }

    private Tuple parseCSVRecord(CSVRecord record) {
        Object[] values = new Object[sourceSchema.getFieldCount()];
        List<Field> fields = sourceSchema.getFields();
        for (int i = 0; i < values.length; i++) {
            Field field = fields.get(i);
            String value = record.get(field.getFieldName());
            try {
                values[i] = parseCSVValue(value, field.getFieldType(), field.getFieldName());
            } catch (Exception e) {
                LOGGER.warn("Ignored illegal value {} for {}", value, field.getFieldName());
            }
        }
        return new Tuple(outputSchema, values);
    }

    private Object parseCSVValue(String value, FieldType type, String fieldName) throws ParseException {
        if (value == null || value.equals("NULL")) {
            return null;
        }
        switch (type.getFieldTypeName()) {
            case INTEGER:
                return Integer.valueOf(value);
            case REAL:
                return Double.valueOf(value);
            case BOOLEAN:
                return Boolean.valueOf(value);
            case STRING:
                return value;
            case ARRAY:
            case STRUCT:
                return JsonReader.parseJson(jsonParser.parse(value), type, fieldName);
            default:
                throw new UnsupportedOperationException("Unknown type " + type);
        }
    }

    @Override
    public void close() throws IOException {
        super.close();
        if (parser != null) {
            parser.close();
            parser = null;
            iterator = null;
        }
    }

}
