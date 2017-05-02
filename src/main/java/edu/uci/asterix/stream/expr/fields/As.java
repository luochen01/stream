package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.expr.UnaryExpr;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;

public class As extends UnaryExpr {

    protected final String name;

    public As(Expr child, String name) {
        super(child);
        this.name = name;
    }

    @Override
    public FieldType getResultType() {
        return child.getResultType();
    }

    public Field getField() {
        return new Field(name, getResultType());
    }

    @Override
    public Object eval(Tuple input) {
        return child.eval(input);
    }

}
