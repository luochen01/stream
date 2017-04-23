package edu.uci.asterix.stream.execution.operators;

import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rex.RexNode;

import edu.uci.asterix.stream.execution.ITuple;

public class StreamFilterOperator extends UnaryStreamOperator {

    protected final RexNode condition;

    public StreamFilterOperator(IStreamOperator child, RexNode condition) {
        super(child);
        this.condition = condition;
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
