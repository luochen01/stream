package edu.uci.asterix.stream.execution.eval;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.asterix.stream.conf.StreamConfig;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.utils.Assertion;

public class SensorToStreamEvaluator implements ISensorToStreamEvaluator {
    private static final Logger logger = LoggerFactory.getLogger(SensorToStreamEvaluator.class);

    private FieldAccess streamSensorIdAccessor;

    private Set<Object> sensorIds;

    @Override
    public void initialize(StructType streamSchema, StructType sensorSchema, List<Tuple> sensors) {

        Field sensorId = sensorSchema.getField(StreamConfig.Instance.sensorIdField(), true);
        Assertion.asserts(sensorId != null, StreamConfig.Instance.sensorIdField() + " is not found for Sensor");
        FieldAccess sensorIdAccessor = new FieldAccess(sensorId, sensorSchema);
        sensorIds = new HashSet<>();
        for (Tuple sensor : sensors) {
            Object id = sensorIdAccessor.eval(sensor);
            if (id == null) {
                logger.error("Ignored invalid sensor tuple " + sensor);
            } else {
                sensorIds.add(id);
            }
        }

        Field streamSensorId = streamSchema.getField(StreamConfig.Instance.streamSensorIdField(), true);
        Assertion.asserts(streamSensorId != null,
                StreamConfig.Instance.sensorIdField() + " is not found for ObservationStream");
        streamSensorIdAccessor = new FieldAccess(streamSensorId, streamSchema);
    }

    @Override
    public boolean evaluate(Tuple streamTuple) {
        Object id = streamSensorIdAccessor.eval(streamTuple);
        if (id == null) {
            logger.error("Ignored invalid stream tuple " + streamTuple);
        }
        return sensorIds.contains(id);
    }

}
