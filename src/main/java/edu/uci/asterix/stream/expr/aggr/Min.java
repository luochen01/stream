package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.utils.Assertion;

public class Min extends AggregateExpr {

    public Min(Expr child) {
        super("MIN", child);
        Assertion.asserts(child.getResultType().getFieldTypeName().isNumerical(),
                "MIN only applies to numerical field");
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

}
