package edu.uci.asterix.stream.expr.arithm;

import edu.uci.asterix.stream.expr.BinaryExpr;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class BinaryArithmeticExpr extends BinaryExpr<Expr> implements ArithmeticExpr {

    public BinaryArithmeticExpr(String symbol, Expr left, Expr right) {
        super(symbol, left, right);

        Assertion.asserts(this.left.getResultType().getFieldTypeName().isNumerical(),
                "Arithmetic operation only applies to numerical fields.");
        Assertion.asserts(this.right.getResultType().getFieldTypeName().isNumerical(),
                "Arithmetic operation only applies to numerical fields.");
    }

    @Override
    public FieldType getResultType() {
        FieldType leftType = left.getResultType();
        FieldType rightType = right.getResultType();
        return leftType.upcast(rightType);
    }

}
