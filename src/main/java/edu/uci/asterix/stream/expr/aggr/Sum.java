package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.operators.GroupbyKey;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.utils.Assertion;

public class Sum extends AggregateExpr {

    public Sum(Expr child) {
        super("SUM", child);
        Assertion.asserts(child.getResultType().getFieldTypeName().isNumerical(),
                "SUM only applies to numerical field");
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new Sum(children[0]);
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
            return (int) currentValue + (int) value;
        } else {
            return (double) currentValue + (double) input.get(id);
        }
    }

}
