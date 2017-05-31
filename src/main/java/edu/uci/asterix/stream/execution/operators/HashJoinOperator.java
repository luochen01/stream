package edu.uci.asterix.stream.execution.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.BinaryPredicateExpr;
import edu.uci.asterix.stream.expr.logic.EqualTo;
import edu.uci.asterix.stream.expr.logic.In;
import edu.uci.asterix.stream.logical.LogicalJoin;
import edu.uci.asterix.stream.utils.Assertion;

public class HashJoinOperator extends BinaryOperator<LogicalJoin> {

    /**
     * Must be one of {@link EqualTo} or {@link In}
     */
    protected final BinaryPredicateExpr condition;

    protected Map<Object, List<Tuple>> rightHash;

    private Iterator<Tuple> rightIter;

    private Tuple leftTuple;

    public HashJoinOperator(Operator left, Operator right, LogicalJoin logicalJoin) {
        super(left, right, logicalJoin);
        Assertion.asserts(logicalJoin.isEquiJoin());
        this.condition = (BinaryPredicateExpr) logicalJoin.getJoinCondition();
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
        while (rightIter != null && rightIter.hasNext()) {
            return Tuple.merge(leftTuple, rightIter.next(), getSchema());
        }
        rightIter = null;
        //exhaust all entries on left -> get next right & reinitialize left array
        while ((leftTuple = left.next()) != null) {
            if (rightHash == null) {
                return null;
            }
            joinedTuple.left = leftTuple;
            joinedTuple.right = null;
            Object leftValue = condition.getLeft().eval(joinedTuple);
            if (leftValue == null) {
                continue;
            }
            List<Tuple> rightList = rightHash.get(leftValue);
            if (rightList != null) {
                rightIter = rightList.iterator();
                if (rightIter.hasNext()) {
                    return Tuple.merge(leftTuple, rightIter.next(), getSchema());
                }
            }
        }
        return null;
    }

    @Override
    public void reset() {
        super.reset();
        if (rightHash != null) {
            rightHash.clear();
            rightHash = null;
        }
        rightIter = null;
        leftTuple = null;
    }

    @Override
    public void initialize() {
        super.initialize();

        Tuple rightTuple = null;
        while ((rightTuple = right.next()) != null) {
            joinedTuple.left = null;
            joinedTuple.right = rightTuple;
            Object rightValue = condition.getRight().eval(joinedTuple);
            if (rightValue == null) {
                continue;
            }

            if (condition instanceof In) {
                Assertion.asserts(rightValue instanceof Object[], "The RHS of IN must be Array type");
                for (Object rightEle : (Object[]) rightValue) {
                    addToHashTable(rightEle, rightTuple);
                }
            } else {
                addToHashTable(rightValue, rightTuple);
            }
        }
    }

    private void addToHashTable(Object value, Tuple tuple) {
        //we should ignore null values
        if (rightHash == null) {
            rightHash = new HashMap<>();
        }
        List<Tuple> tuples = rightHash.get(value);
        if (tuples == null) {
            tuples = new ArrayList<Tuple>();
        }
        tuples.add(tuple);
        rightHash.put(value, tuples);

    }

}
