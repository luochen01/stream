package edu.uci.asterix.stream.expr.arithm;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class BinaryArithmeticExpr extends ArithmeticExpr {
    protected final Expr left;
    protected final Expr right;

    public BinaryArithmeticExpr(String symbol, Expr left, Expr right) {
        super(symbol);
        this.left = left;
        this.right = right;

        Assertion.asserts(this.left.getResultType().getFieldTypeName().isNumerical(),
                "Arithmetic operation only applies to numerical fields.");
        Assertion.asserts(this.right.getResultType().getFieldTypeName().isNumerical(),
                "Arithmetic operation only applies to numerical fields.");
    }

    @Override
    public Expr[] children() {
        return new Expr[] { left, right };
    }

    @Override
    public FieldType getResultType() {
        FieldType leftType = left.getResultType();
        FieldType rightType = right.getResultType();
        return leftType.upcast(rightType);
    }

    @Override
    public String toString() {
        return left + " " + symbol + " " + right;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        BinaryArithmeticExpr other = (BinaryArithmeticExpr) obj;
        if (left == null) {
            if (other.left != null)
                return false;
        } else if (!left.equals(other.left))
            return false;
        if (right == null) {
            if (other.right != null)
                return false;
        } else if (!right.equals(other.right))
            return false;
        return true;
    }

}
