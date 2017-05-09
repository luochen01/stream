package edu.uci.asterix.stream.expr.aggr;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
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

}
