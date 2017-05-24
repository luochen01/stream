package edu.uci.asterix.stream.execution.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalJoin;

public class LoopJoinOperator extends BinaryOperator<LogicalJoin> {

    protected final LogicExpr condition;
    private List<Tuple> leftList;
    private Iterator<Tuple> leftItr;
    private Tuple rightTuple;

    private final PairedTuple joinedTuple;

    /**
     * A simple trick to avoid create tuples every time when we test the join condition
     *
     * @author luochen
     */
    private class PairedTuple extends Tuple {

        public Tuple left;

        public Tuple right;

        public PairedTuple(StructType schema) {
            super(schema);
        }

        @Override
        public Object get(int i) {
            assert (left != null && right != null);
            if (i < left.getFieldCount()) {
                return left.get(i);
            } else {
                return right.get(i - left.getFieldCount());
            }
        }
    }

    public LoopJoinOperator(Operator left, Operator right, LogicalJoin logicalJoin) {
        super(left, right, logicalJoin);
        this.condition = logicalJoin.getJoinCondition();
        this.joinedTuple = new PairedTuple(getSchema());
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
                joinedTuple.left = leftTuple;
                joinedTuple.right = rightTuple;
                if ((boolean) condition.eval(joinedTuple)) {
                    return joinedTuple;
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
