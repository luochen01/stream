package edu.uci.asterix.stream.expr;

import edu.uci.asterix.stream.exception.StreamExecutionException;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.FieldType;

public interface Expr {

    public boolean fastEqual(Expr another);

    public int getId();

    public Expr[] children();

    public FieldType getResultType();

    public Object eval(Tuple input) throws StreamExecutionException;

    @Override
    public String toString();

    public Expr withChildren(Expr... children);

    public String getSymbol();

    public Field toField();
}
