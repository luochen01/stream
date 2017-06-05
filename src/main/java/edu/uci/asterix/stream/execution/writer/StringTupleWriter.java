package edu.uci.asterix.stream.execution.writer;

import java.io.IOException;
import java.io.OutputStream;

import edu.uci.asterix.stream.execution.DefaultSystemTimeProvider;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.utils.Utils;

public class StringTupleWriter extends AbstractTupleWriter {

    public StringTupleWriter(OutputStream out) {
        super(out);
    }

    @Override
    public void write(Tuple tuple) throws IOException {
        writer.write(Utils.getTimeString(DefaultSystemTimeProvider.INSTANCE.currentTimeMillis()));
        writer.write(":");
        writer.write(tuple.toString());
        writer.newLine();
        writer.flush();
    }

}
