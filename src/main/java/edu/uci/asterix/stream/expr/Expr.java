package edu.uci.asterix.stream.expr;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.FieldType;

public abstract class Expr {
    public abstract Expr[] operands();

    public abstract FieldType getResultType();

    public abstract Object eval(Tuple input);
}
