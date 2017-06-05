package edu.uci.asterix.stream.expr;

import java.util.Arrays;

import edu.uci.asterix.stream.field.Field;

public abstract class AbstractExpr<T extends Expr> implements Expr {

    protected static int nextId = 0;

    protected final int id = nextId++;

    protected final String symbol;

    public AbstractExpr(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean fastEqual(Expr another) {
        if (another == null) {
            return false;
        }
        return this.id == another.getId();
    }

    @Override
    public Field toField() {
        return new Field("expr#" + id, getResultType());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public final int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        @SuppressWarnings("unchecked")
        AbstractExpr<T> other = (AbstractExpr<T>) obj;
        if (symbol == null) {
            if (other.symbol != null)
                return false;
        } else if (!symbol.equals(other.symbol))
            return false;

        Expr[] children = this.children();
        Expr[] otherChildren = other.children();
        if (!Arrays.equals(children, otherChildren)) {
            return false;
        }
        return true;
    }

}
