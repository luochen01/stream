package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.logical.LogicalJoin;

public class LoopJoinOperator extends BinaryOperator<LogicalJoin> {

    protected final LogicExpr condition;

    public LoopJoinOperator(Operator left, Operator right, LogicalJoin logicalJoin) {
        super(left, right, logicalJoin);
        this.condition = logicalJoin.getJoinCondition();
    }

    @Override
    public String getName() {
        return "LOOP JOIN";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(condition);

    }

    @Override
    protected Tuple nextImpl() {
        //TODO
        return null;
    }

}
