package edu.uci.asterix.stream.expr;

public abstract class BinaryExpr<T extends Expr> extends AbstractExpr<T> {

    protected T left;
    protected T right;

    public BinaryExpr(String symbol, T left, T right) {
        super(symbol);
        this.left = left;
        this.right = right;
    }

    @Override
    public Expr[] children() {
        return new Expr[] { left, right };
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " " + symbol + " " + right.toString() + ")";
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        BinaryExpr<T> other = (BinaryExpr<T>) obj;
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
