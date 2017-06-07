package edu.uci.asterix.stream.api;

import edu.uci.asterix.stream.execution.DefaultSystemTimeProvider;
import edu.uci.asterix.stream.execution.SystemTimeProvider;
import edu.uci.asterix.stream.execution.eval.CSVStreamConnector;
import edu.uci.asterix.stream.execution.eval.ISensorToStreamEvaluator;
import edu.uci.asterix.stream.execution.eval.IStreamConnector;
import edu.uci.asterix.stream.execution.eval.SensorToStreamEvaluator;
import edu.uci.asterix.stream.execution.writer.ITupleWriter;
import edu.uci.asterix.stream.execution.writer.StringTupleWriter;

public class QueryConfig implements IQueryConfig {
    @Override
    public SystemTimeProvider createTimeProvider() {
        return DefaultSystemTimeProvider.INSTANCE;
    }

    @Override
    public ISensorToStreamEvaluator createSensorStreamEvaluator() {
        return new SensorToStreamEvaluator();
    }

    @Override
    public IStreamConnector createStreamConnector() {
        //TODO: change connector
        return new CSVStreamConnector("src/main/resources/data/WifiAPTuples.csv");
    }

    @Override
    public ITupleWriter createTupleWriter() {
        return new StringTupleWriter(System.out);
    }

}
