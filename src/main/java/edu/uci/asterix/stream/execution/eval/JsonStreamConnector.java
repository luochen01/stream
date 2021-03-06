package edu.uci.asterix.stream.execution.eval;

import java.io.FileInputStream;
import java.io.IOException;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.reader.ITupleReader;
import edu.uci.asterix.stream.execution.reader.JsonReader;
import edu.uci.asterix.stream.field.StructType;

public class JsonStreamConnector implements IStreamConnector {

    private ITupleReader jsonReader;

    private final String file;

    public JsonStreamConnector(String file) {
        this.file = file;
    }

    @Override
    public void initialize(StructType sourceSchema, StructType outputSchema) throws Exception {
        this.jsonReader = new JsonReader(sourceSchema, outputSchema, new FileInputStream(file));
    }

    @Override
    public Tuple next() {
        if (jsonReader == null) {
            throw new IllegalStateException("Connector has not been initialized");
        }
        return jsonReader.nextTuple();

    }

    @Override
    public void close() throws IOException {
        if (jsonReader != null) {
            jsonReader.close();
        }
    };

}
