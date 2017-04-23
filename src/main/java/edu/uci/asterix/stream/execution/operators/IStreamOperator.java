package edu.uci.asterix.stream.execution.operators;

import org.apache.calcite.rel.type.RelDataType;

import edu.uci.asterix.stream.execution.ITuple;

public interface IStreamOperator {

    public boolean hasNext();

    public ITuple next();

    public RelDataType getFields();

}