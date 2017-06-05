package edu.uci.asterix.stream.execution.eval;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import edu.uci.asterix.stream.conf.StreamConfig;
import edu.uci.asterix.stream.execution.SystemTimeProvider;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.reader.ITupleReader;
import edu.uci.asterix.stream.execution.reader.JsonReader;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.utils.Assertion;
import edu.uci.asterix.stream.utils.Utils;

public class JsonStreamConnector implements IStreamConnector {

    private ITupleReader jsonReader;

    private final SystemTimeProvider provider;

    private final String file;

    private int timeFieldIndex;

    private final Random random = new Random(System.currentTimeMillis());

    public JsonStreamConnector(String file, SystemTimeProvider timeProvider) {
        this.file = file;
        this.provider = timeProvider;
    }

    @Override
    public void initialize(StructType sourceSchema, StructType outputSchema) throws Exception {
        this.jsonReader = new JsonReader(sourceSchema, outputSchema, new FileInputStream(file));

        timeFieldIndex = sourceSchema.getFieldIndex(StreamConfig.Instance.streamTimeField());
        Assertion.asserts(timeFieldIndex >= 0);

    }

    @Override
    public Tuple next() {
        if (jsonReader == null) {
            throw new IllegalStateException("Connector has not been initialized");
        }
        Tuple tuple = jsonReader.nextTuple();
        if (tuple != null) {
            try {
                Thread.sleep(random.nextInt(200) + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tuple.getAllValues()[timeFieldIndex] = Utils.getTimeString(provider.currentTimeMillis());
            return tuple;
        } else {
            return null;
        }

    }

    @Override
    public void close() throws IOException {
        if (jsonReader != null) {
            jsonReader.close();
        }
    };

}
