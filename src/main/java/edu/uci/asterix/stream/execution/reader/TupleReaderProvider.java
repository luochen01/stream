package edu.uci.asterix.stream.execution.reader;

import java.io.IOException;
import java.io.InputStream;

import org.json.simple.parser.ParseException;

import edu.uci.asterix.stream.catalog.Table.InputFormat;
import edu.uci.asterix.stream.field.StructType;

public class TupleReaderProvider {

    public static TupleReaderProvider INSTANCE = new TupleReaderProvider();

    private TupleReaderProvider() {

    }

    public ITupleReader create(InputFormat format, StructType schema, InputStream input)
            throws IOException, ParseException {
        switch (format) {
            case JSON:
                return new JsonReader(schema, input);
            default:
                throw new UnsupportedOperationException("Unsupported input format " + format);
        }

    }

}
