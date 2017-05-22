package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.ComparisonExpr;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.logical.LogicalJoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LoopJoinOperator extends BinaryOperator<LogicalJoin> {

    protected final LogicExpr condition;
    protected final LogicalJoin logicalJoin;
    private List<Tuple> leftList;
    private Iterator<Tuple> leftItr;
    //Keep left in the list, iterate through right

    public LoopJoinOperator(Operator left, Operator right, LogicalJoin logicalJoin) {
        super(left, right, logicalJoin);
        this.condition = logicalJoin.getJoinCondition();
        this.logicalJoin = logicalJoin;
        this.leftList = new ArrayList<>();

        Tuple leftTuple;
        while((leftTuple = left.next()) != null){
            leftList.add(leftTuple);
        }
        leftItr = leftList.iterator();
    }

    @Override public String getName() {
        return "LOOP JOIN";
    }

    @Override protected void printContent(StringBuilder sb) {
        sb.append(condition);

    }

    @Override public Tuple next() {
        Tuple rightChild;
        while ((rightChild = right.next()) != null) {

            while (leftItr.hasNext()) {
                Tuple leftTuple = leftItr.next();
                List<Object> fields = new ArrayList<>();
                fields.addAll(Arrays.asList(leftTuple.getAllValues()));
                fields.addAll(Arrays.asList(rightChild.getAllValues()));
                Tuple concat = new Tuple(logicalJoin.getSchema(), fields.toArray());
                if ((boolean) condition.eval(concat)) {
                    return concat;
                }
            }

        }
        return null;
    }

}
