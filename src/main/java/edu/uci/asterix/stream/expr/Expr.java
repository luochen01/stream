package edu.uci.asterix.stream.expr;

import java.util.ArrayList;
import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;

public abstract class Expr {

    protected static int nextId = 0;

    protected final int id = nextId++;

    protected final String symbol;

    public Expr(String symbol) {
        this.symbol = symbol;
    }

    public boolean fastEqual(Expr another) {
        if (another == null) {
            return false;
        }
        return this.id == another.id;
    }

    public abstract Expr[] children();

    public abstract FieldType getResultType();

    public abstract Object eval(Tuple input);

    public abstract String toString();

    public Field toField() {
        return new Field("expr#" + id, getResultType());
    }

    @Override
    public final int hashCode() {
        throw new UnsupportedOperationException();
    }

    public List<Expr> collect(Class<? extends Expr> clazz) {
        List<Expr> list = new ArrayList<>();
        collectImpl(clazz, list);
        return list;
    }

    private void collectImpl(Class<? extends Expr> clazz, List<Expr> list) {
        for (Expr child : children()) {
            child.collectImpl(clazz, list);
        }
        if (clazz.isInstance(this)) {
            list.add(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Expr other = (Expr) obj;
        if (symbol == null) {
            if (other.symbol != null)
                return false;
        } else if (!symbol.equals(other.symbol))
            return false;
        return true;
    }

}
