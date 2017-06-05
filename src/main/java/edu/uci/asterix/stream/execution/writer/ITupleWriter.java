package edu.uci.asterix.stream.execution.writer;

import java.io.IOException;

import edu.uci.asterix.stream.execution.Tuple;

public interface ITupleWriter {

    public void write(Tuple tuple) throws IOException;

    public void flush() throws IOException;

    public void close() throws IOException;

}
