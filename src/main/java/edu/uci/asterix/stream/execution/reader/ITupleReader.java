package edu.uci.asterix.stream.execution.reader;

import java.io.IOException;

import edu.uci.asterix.stream.execution.Tuple;

public interface ITupleReader {

    public Tuple nextTuple();

    public void close() throws IOException;

}
