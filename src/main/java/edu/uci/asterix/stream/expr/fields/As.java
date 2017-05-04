package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.UnaryExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;

public class As extends UnaryExpr {

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
        return name;
    }

    @Override
    public Object eval(Tuple input) {
        return child.eval(input);
    }

}
