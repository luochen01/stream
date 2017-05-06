package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.field.StructType;

public class LoopJoinOperator extends BinaryOperator {

    protected final LogicExpr condition;

    public LoopJoinOperator(Operator left, Operator right, LogicExpr condition) {
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
