package edu.uci.asterix.stream.expr;

import edu.uci.asterix.stream.exception.StreamExecutionException;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.field.FieldTypeName;
import edu.uci.asterix.stream.field.PrimitiveType;
import edu.uci.asterix.stream.utils.Assertion;

public class Cast extends UnaryExpr<Expr> {

    private final PrimitiveType resultType;

    public Cast(Expr child, FieldTypeName name) {
        super("CAST", child);
        resultType = PrimitiveType.get(name);
        Assertion.asserts(resultType != null, name + " is not a valid primitive type");
        Assertion.asserts(child.getResultType() instanceof PrimitiveType, "CAST only supports primitive types");
    }

    @Override
    public FieldType getResultType() {
        return resultType;
    }

    @Override
    public Object eval(Tuple input) throws StreamExecutionException {
        Object value = child.eval(input);
        if (value == null) {
            return null;
        }
        try {
            switch (resultType.getFieldTypeName()) {
                case BOOLEAN:
                    return Boolean.valueOf(String.valueOf(value));
                case INTEGER:
                    return Integer.valueOf(String.valueOf(value));
                case REAL:
                    return Double.valueOf(String.valueOf(value));
                case STRING:
                    return String.valueOf(value);
                default:
                    throw new UnsupportedOperationException(
                            "CAST is not supported on " + child.getResultType().getFieldTypeName());
            }
        } catch (NumberFormatException e) {
            throw new StreamExecutionException(
                    value + " is not a valid value of type " + resultType.getFieldTypeName());
        }

    }

    @Override
    public Expr withChildren(Expr... children) {
        return new Cast(children[0], resultType.getFieldTypeName());
    }

    @Override
    public String toString() {
        return "CAST(" + child.toString() + " AS " + resultType.getFieldTypeName() + ")";
    }

}
