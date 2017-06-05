package edu.uci.asterix.stream.execution.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public abstract class AbstractTupleWriter implements ITupleWriter {

    protected BufferedWriter writer;

    public AbstractTupleWriter(OutputStream out) {
        writer = new BufferedWriter(new OutputStreamWriter(out));
    }

    @Override
    public void close() throws IOException {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    };

    @Override
    public void flush() throws IOException {
        writer.flush();

    }
}
