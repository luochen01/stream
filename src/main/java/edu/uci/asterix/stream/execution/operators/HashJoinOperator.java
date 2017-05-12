package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.logical.LogicalJoin;
import edu.uci.asterix.stream.utils.Assertion;

public class HashJoinOperator extends BinaryOperator<LogicalJoin> {

    protected final EqualTo condition;

    public HashJoinOperator(Operator left, Operator right, LogicalJoin logicalJoin) {
        super(left, right, logicalJoin);
        Assertion.asserts(logicalJoin.isEquiJoin());
        this.condition = (EqualTo) logicalJoin.getJoinCondition();
    }

    @Override
    public String getName() {
        return "HASH JOIN";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(condition);
    }

    @Override
    public Tuple next() {
        // TODO Auto-generated method stub
        return null;
    }

}
