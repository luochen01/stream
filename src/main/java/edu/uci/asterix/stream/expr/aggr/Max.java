package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.operators.GroupbyKey;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

public class Max extends AggregateExpr {

    public Max(Expr child) {
        super("MAX", child);
        Assertion.asserts(child.getResultType().getFieldTypeName().isNumerical(),
                "MAX only applies to numerical field");

    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new Max(children[0]);
    }

    @Override
    public Object compute(GroupbyKey key, Object currentValue, Tuple input) {
        Object value = child.eval(input);
        if (currentValue == null) {
            return value;
        }
        if (value == null) {
            return currentValue;
        }

        if (child.getResultType().getFieldTypeName() == FieldTypeName.INTEGER) {
            return Integer.max((int) currentValue, (int) value);
        } else {
            return Double.max((double) currentValue, (double) value);
        }
    }
}
