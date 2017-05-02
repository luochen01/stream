package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.utils.Assertion;

public class Sum extends AggregateExpr {

    public Sum(Expr child) {
        super(child);
        Assertion.asserts(child.getResultType().getFieldTypeName().isNumerical());
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

}
