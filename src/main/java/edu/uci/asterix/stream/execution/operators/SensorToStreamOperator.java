package edu.uci.asterix.stream.execution.operators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.asterix.stream.catalog.ObservationStream;
import edu.uci.asterix.stream.exception.StreamExecutionException;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.eval.ISensorToStreamEvaluator;
import edu.uci.asterix.stream.execution.eval.IStreamConnector;
import edu.uci.asterix.stream.logical.LogicalStreamScan;

/**
 * @author luochen
 */
public class SensorToStreamOperator extends AbstractStreamOperator<LogicalStreamScan> {

    private final static Logger LOGGER = LoggerFactory.getLogger(SensorToStreamOperator.class);

    protected final ObservationStream stream;

    protected final Operator child;

    protected final ISensorToStreamEvaluator evaluator;

    protected IStreamConnector connector;

    public SensorToStreamOperator(Operator child, LogicalStreamScan logicalScan, ISensorToStreamEvaluator evaluator,
            IStreamConnector connector) {
        super(logicalScan);
        this.child = child;
        this.stream = logicalScan.getTable();
        this.evaluator = evaluator;
        this.connector = connector;
    }

    @Override
    public void initialize() {
        child.initialize();
        List<Tuple> sensors = new ArrayList<>();
        Tuple tuple;
        while ((tuple = child.next()) != null) {
            sensors.add(tuple);
            LOGGER.info("Connecting Sensor {} to fetch streams", tuple);
        }
        LOGGER.info("Connected {} sensors", sensors.size());

        this.evaluator.initialize(getSchema(), child.getSchema(), sensors);
        try {
            this.connector.initialize(stream.getSchema(), getSchema());
        } catch (Exception e) {
            throw new StreamExecutionException("Fail to initialize stream connector", e);
        }
    }

    @Override
    public Operator[] children() {
        return new Operator[] { child };
    }

    @Override
    public String getName() {
        return "SensorToObservationStream";
    }

    @Override
    public Tuple next() {
        Tuple tuple;
        while ((tuple = connector.next()) != null) {
            if (evaluator.evaluate(tuple)) {
                return tuple;
            }
        }

        try {
            connector.close();
        } catch (IOException e) {
            LOGGER.error("Error occured when close StreamConnector", e);
        }
        return null;

    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(stream.getTableName());
        if (!logicalPlan.getAlias().equals(stream.getTableName())) {
            sb.append(" AS ");
            sb.append(logicalPlan.getAlias());
        }
    }

}
