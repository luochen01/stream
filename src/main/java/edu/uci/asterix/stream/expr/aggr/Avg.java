package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.utils.Assertion;

public class Avg extends AggregateExpr {

    public Avg(Expr child) {
        super("AVG", child);
        Assertion.asserts(child.getResultType().getFieldTypeName().isNumerical(),
                "AVG only applies to numerical field");
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

}
