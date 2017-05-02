package edu.uci.asterix.stream.expr.fields;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.func.Function;
import edu.uci.asterix.stream.utils.Assertion;

public class FunctionCall extends Expr {

    protected final Expr[] arguments;

    protected final Function function;

    public FunctionCall(Function function, Expr[] arguments) {
        this.function = function;
        this.arguments = arguments;

        Assertion.asserts(function.numParams() == arguments.length);
        for (int i = 0; i < arguments.length; i++) {
            Assertion.asserts(function.getParamType(i).compatible(arguments[i].getResultType()));
        }
    }

    @Override
    public Expr[] operands() {
        return arguments;
    }

    @Override
    public FieldType getResultType() {
        return function.getReturnType();
    }

    @Override
    public Object eval(Tuple input) {
        Object[] evals = new Object[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            evals[i] = arguments[i].eval(input);
        }
        return function.eval(evals);
    }

}
