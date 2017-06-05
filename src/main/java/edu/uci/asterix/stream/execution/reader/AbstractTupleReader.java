package edu.uci.asterix.stream.execution.reader;

import java.io.IOException;
import java.io.InputStream;

import edu.uci.asterix.stream.field.StructType;

public abstract class AbstractTupleReader implements ITupleReader {

    protected final StructType sourceSchema;

    protected final StructType outputSchema;

    protected InputStream input;

    public AbstractTupleReader(StructType sourceSchema, StructType outputSchema, InputStream input) {
        this.sourceSchema = sourceSchema;
        this.outputSchema = outputSchema;
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
