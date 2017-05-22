package edu.uci.asterix.stream.execution.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.logical.LogicalJoin;
import edu.uci.asterix.stream.utils.Assertion;

public class HashJoinOperator extends BinaryOperator<LogicalJoin> {

    protected final EqualTo condition;

    protected Map<Object, List<Tuple>> leftHash;

    private Iterator<Tuple> leftItr;

    private Tuple rightTuple;

    //TODO: load left table into memory in chunks
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
        //Return merge tuple of left+right
        while (leftItr != null && leftItr.hasNext()) {
            return Tuple.merge(leftItr.next(), rightTuple, getSchema());
        }

        //exhaust all entries on left -> get next right & reinitialize left array
        while ((rightTuple = right.next()) != null) {
            Object rightValue = condition.getRight().eval(rightTuple);
            if (rightValue == null) {
                continue;
            }
            List<Tuple> leftList = leftHash.get(rightValue);
            if (leftList != null) {
                leftItr = leftList.iterator();
                if (leftItr.hasNext()) {
                    return Tuple.merge(leftItr.next(), rightTuple, getSchema());
                }
            }
        }
        return null;
    }

    @Override
    public void reset() {
        super.reset();
        if (leftHash != null) {
            leftHash.clear();
            leftHash = null;
        }
        leftItr = null;
        rightTuple = null;
    }

    @Override
    public void initialize() {
        super.initialize();

        Tuple leftTuple = null;
        while ((leftTuple = left.next()) != null) {
            Object leftValue = condition.getLeft().eval(leftTuple);
            if (leftValue != null) {
                //we should ignore null values
                List<Tuple> tuples = leftHash.get(leftValue);
                if (tuples == null) {
                    tuples = new ArrayList<Tuple>();
                    leftHash.put(leftValue, tuples);
                }
                tuples.add(leftTuple);
            }
        }
    }

}
