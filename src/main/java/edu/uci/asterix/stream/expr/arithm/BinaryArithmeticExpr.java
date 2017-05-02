package edu.uci.asterix.stream.expr.arithm;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class BinaryArithmeticExpr extends ArithmeticExpr {
    protected final Expr left;
    protected final Expr right;

    public BinaryArithmeticExpr(Expr left, Expr right) {
        this.left = left;
        this.right = right;

        Assertion.asserts(this.left.getResultType().getFieldTypeName().isNumerical());
        Assertion.asserts(this.right.getResultType().getFieldTypeName().isNumerical());
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { left, right };
    }

    @Override
    public FieldType getResultType() {
        FieldType leftType = left.getResultType();
        FieldType rightType = right.getResultType();
        return leftType.upcast(rightType);
    }
}
