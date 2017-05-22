package edu.uci.asterix.stream.execution.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.logical.LogicalJoin;

public class LoopJoinOperator extends BinaryOperator<LogicalJoin> {

    protected final LogicExpr condition;
    private List<Tuple> leftList;
    private Iterator<Tuple> leftItr;
    private Tuple rightTuple;

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
    public Tuple next() {
        while ((rightTuple != null)) {
            while (leftItr.hasNext()) {
                Tuple leftTuple = leftItr.next();
                Tuple tuple = Tuple.merge(leftTuple, rightTuple, getSchema());
                if ((boolean) condition.eval(tuple)) {
                    return tuple;
                }
            }
            rightTuple = right.next();
            leftItr = leftList.iterator();
        }
        return null;
    }

    @Override
    public void reset() {
        super.reset();
        if (leftList != null) {
            leftList.clear();
            leftList = null;
        }
        leftItr = null;
        rightTuple = null;
    }

    @Override
    public void initialize() {
        super.initialize();

        leftList = new ArrayList<>();

        Tuple leftTuple = null;
        while ((leftTuple = left.next()) != null) {
            leftList.add(leftTuple);
        }

        rightTuple = right.next();
        leftItr = leftList.iterator();

    }

}
