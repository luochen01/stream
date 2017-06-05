package edu.uci.asterix.stream.execution.eval;

import java.io.IOException;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.StructType;

public interface IStreamConnector {

    public void initialize(StructType sourceSchema, StructType outputSchema) throws Exception;

    public Tuple next();

    public void close() throws IOException;

}
