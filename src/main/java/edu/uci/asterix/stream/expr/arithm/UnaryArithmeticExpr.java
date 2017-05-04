package edu.uci.asterix.stream.expr.arithm;

import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class UnaryArithmeticExpr extends ArithmeticExpr {

    protected final Expr child;

    public UnaryArithmeticExpr(String symbol, Expr child) {
        super(symbol);
        this.child = child;

        Assertion.asserts(this.child.getResultType().getFieldTypeName().isNumerical(),
                "Arithmetic operator only applies to numerical field");
    }

    @Override
    public Expr[] operands() {
        return new Expr[] { child };
    }

    @Override
    public String toString() {
        return symbol + child;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        UnaryArithmeticExpr other = (UnaryArithmeticExpr) obj;
        if (child == null) {
            if (other.child != null)
                return false;
        } else if (!child.equals(other.child))
            return false;
        return true;
    }

}
