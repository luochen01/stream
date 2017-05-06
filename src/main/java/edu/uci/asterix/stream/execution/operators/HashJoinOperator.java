package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.field.StructType;

public class HashJoinOperator extends BinaryOperator {

    protected final EqualTo condition;

    public HashJoinOperator(Operator left, Operator right, EqualTo condition) {
        super(left, right);
        this.condition = condition;
    }

    @Override
    public StructType getSchema() {
        //TODO
        return null;
    }

    @Override
    protected Tuple nextImpl() {
        //TODO
        return null;
    }

}
