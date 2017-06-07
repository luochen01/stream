package edu.uci.asterix.stream.expr.aggr;

import java.util.HashMap;
import java.util.Map;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.operators.GroupbyKey;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

public class Avg extends AggregateExpr {

    private final Map<GroupbyKey, Integer> groupCounts;

    public Avg(Expr child) {
        super("AVG", child);
        Assertion.asserts(child.getResultType().getFieldTypeName().isNumerical(),
                "AVG only applies to numerical field");
        groupCounts = new HashMap<>();
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new Avg(children[0]);
    }

    @Override
    public Object compute(GroupbyKey key, Object currentValue, Tuple input) {

        Object value = child.eval(input);
        if (value == null) {
            return currentValue;
        }
        int totalSlot = 1;
        if (groupCounts.get(key) != null) {
            totalSlot = groupCounts.get(key) + 1;
        }
        groupCounts.put(key, totalSlot);

        if (currentValue == null) {
            return value;
        }

        if (child.getResultType().getFieldTypeName() == FieldTypeName.INTEGER) {
            return ((int) currentValue * (totalSlot - 1) + (int) value) / totalSlot;
        } else {
            return ((double) currentValue * (totalSlot - 1) + (double) value) / totalSlot;
        }
    }

    @Override
    public void reset() {
        groupCounts.clear();
    }

}
