package edu.uci.asterix.stream.execution.eval;

import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.StructType;

public interface ISensorToStreamEvaluator {

    public void initialize(StructType streamSchema, StructType sensorSchema, List<Tuple> sensors);

    public boolean evaluate(Tuple streamTuple);

}
