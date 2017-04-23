package edu.uci.asterix.stream.execution.operators;

import org.apache.calcite.rel.type.RelDataType;

import edu.uci.asterix.stream.execution.ITuple;

public class StreamProjectOperator extends UnaryStreamOperator {

    public StreamProjectOperator(IStreamOperator child) {
        super(child);
    }

    @Override
    public boolean hasNext() {
        return child.hasNext();
    }

    @Override
    public ITuple next() {
        return child.next();
    }

    @Override
    public RelDataType getFields() {
        return child.getFields();
    }

}
