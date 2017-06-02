package edu.uci.asterix.stream.execution.reader;

import java.io.IOException;
import java.io.InputStream;

import edu.uci.asterix.stream.field.StructType;

public abstract class AbstractTupleReader implements ITupleReader {

    protected final StructType schema;

    protected InputStream input;

    public AbstractTupleReader(StructType schema, InputStream input) {
        this.schema = schema;
        this.input = input;
    }

    @Override
    public void close() throws IOException {
        if (this.input != null) {
            this.input.close();
            this.input = null;
        }

    }

}
