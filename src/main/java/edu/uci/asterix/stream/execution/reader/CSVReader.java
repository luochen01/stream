package edu.uci.asterix.stream.execution.reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.uci.asterix.stream.exception.StreamExecutionException;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.StructType;

public class CSVReader extends AbstractTupleReader {

    private Iterator<CSVRecord> iterator;
    private CSVParser parser;

    public CSVReader(StructType sourceSchema, StructType outputSchema, InputStream input) throws IOException {
        super(sourceSchema, outputSchema, input);
        sourceSchema.getFields().forEach(field -> {
            if (!field.getFieldType().isPrimitive()) {
                throw new StreamExecutionException(
                        "Field " + field.getFieldName() + " with complex type is not supported by CSV reader");
            }
        });
        parser = CSVFormat.DEFAULT.withHeader().parse(new InputStreamReader(input));
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
                values[i] = parseCSVValue(value, field.getFieldType());
            } catch (Exception e) {

            }
        }
        return new Tuple(outputSchema, values);
    }

    private Object parseCSVValue(String value, FieldType type) {
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
            default:
                throw new UnsupportedOperationException("Unknown primitive type " + type);
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
