package edu.uci.asterix.stream.execution.writer;

import java.io.IOException;
import java.io.OutputStream;

import edu.uci.asterix.stream.execution.Tuple;

public class StringTupleWriter extends AbstractTupleWriter {

    public StringTupleWriter(OutputStream out) {
        super(out);
    }

    @Override
    public void write(Tuple tuple, String window) throws IOException {
        if (window != null) {
            writer.write(window);
            writer.write(":");
        }
        writer.write(tuple.toString());
        writer.newLine();
        writer.flush();
    }

}
