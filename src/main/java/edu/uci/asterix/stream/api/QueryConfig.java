package edu.uci.asterix.stream.api;

import edu.uci.asterix.stream.execution.DefaultSystemTimeProvider;
import edu.uci.asterix.stream.execution.SystemTimeProvider;
import edu.uci.asterix.stream.execution.eval.ISensorToStreamEvaluator;
import edu.uci.asterix.stream.execution.eval.IStreamConnector;
import edu.uci.asterix.stream.execution.eval.JsonStreamConnector;
import edu.uci.asterix.stream.execution.eval.SensorToStreamEvaluator;
import edu.uci.asterix.stream.execution.writer.ITupleWriter;
import edu.uci.asterix.stream.execution.writer.StringTupleWriter;

public class QueryConfig implements IQueryConfig {
    public SystemTimeProvider createTimeProvider() {
        return DefaultSystemTimeProvider.INSTANCE;
    }

    public ISensorToStreamEvaluator createSensorStreamEvaluator() {
        return new SensorToStreamEvaluator();
    }

    public IStreamConnector createStreamConnector() {
        //TODO: change connector
        return new JsonStreamConnector("src/test/resources/data.json", createTimeProvider());
    }

    public ITupleWriter createTupleWriter() {
        return new StringTupleWriter(System.out);
    }

}
