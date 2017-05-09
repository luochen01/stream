package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.UnaryExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;

public class As extends UnaryExpr<Expr> {

    protected final String name;

    public As(Expr child, String name) {
        super("AS", child);
        this.name = name;
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

    @Override
    public Field toField() {
        return new Field(name, getResultType());
    }

    @Override
    public String toString() {
        return child.toString() + " AS " + name;
    }

    @Override
    public Object eval(Tuple input) {
        return child.eval(input);
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new As(children[0], name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        As other = (As) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
