package edu.uci.asterix.stream.api;

import edu.uci.asterix.stream.execution.SystemTimeProvider;
import edu.uci.asterix.stream.execution.eval.ISensorToStreamEvaluator;
import edu.uci.asterix.stream.execution.eval.IStreamConnector;
import edu.uci.asterix.stream.execution.writer.ITupleWriter;

public interface IQueryConfig {
    public SystemTimeProvider createTimeProvider();

    public ISensorToStreamEvaluator createSensorStreamEvaluator();

    public IStreamConnector createStreamConnector();

    public ITupleWriter createTupleWriter();
}
