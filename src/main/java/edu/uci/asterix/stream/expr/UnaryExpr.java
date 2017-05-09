package edu.uci.asterix.stream.expr;

public abstract class UnaryExpr<T extends Expr> extends AbstractExpr<T> {

    protected final T child;

    public UnaryExpr(String symbol, T child) {
        super(symbol);
        this.child = child;
    }

    @Override
    public Expr[] children() {
        return new Expr[] { child };
    }

    public T getChild() {
        return child;
    }

    @Override
    public String toString() {
        return child.toString() + " " + symbol;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        UnaryExpr<T> other = (UnaryExpr<T>) obj;
        if (child == null) {
            if (other.child != null)
                return false;
        } else if (!child.equals(other.child))
            return false;
        return true;
    }

}
