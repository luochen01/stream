package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.logic.ComparisonExpr;
import edu.uci.asterix.stream.expr.logic.LogicExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.logical.LogicalJoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoopJoinOperator extends BinaryOperator<LogicalJoin> {

    protected final LogicExpr condition;
    protected final LogicalJoin logicalJoin;

    public LoopJoinOperator(Operator left, Operator right, LogicalJoin logicalJoin) {
        super(left, right, logicalJoin);
        this.condition = logicalJoin.getJoinCondition();
        this.logicalJoin = logicalJoin;
    }

    @Override public String getName() {
        return "LOOP JOIN";
    }

    @Override protected void printContent(StringBuilder sb) {
        sb.append(condition);

    }

    @Override public Tuple next() {
        Tuple leftChild;
        while ((leftChild = left.next()) != null) {
            Tuple rightChild = null;
            while ((rightChild = right.next()) != null) {
                List<Object> fields = new ArrayList<>();
                fields.addAll(Arrays.asList(leftChild.getAllValues()));
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
