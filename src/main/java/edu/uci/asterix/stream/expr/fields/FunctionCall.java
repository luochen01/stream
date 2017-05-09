package edu.uci.asterix.stream.expr.fields;

import java.util.Arrays;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.AbstractExpr;
import edu.uci.asterix.stream.expr.Expr;
import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.func.Function;
import edu.uci.asterix.stream.utils.Assertion;

public class FunctionCall extends AbstractExpr<Expr> {

    protected final Expr[] arguments;

    protected final Function function;

    public FunctionCall(Function function, Expr[] arguments) {
        super(function.getName());

        this.function = function;
        this.arguments = arguments;

        Assertion.asserts(function.numParams() == arguments.length, function.getName() + " requires "
                + function.numParams() + " parameters, but " + arguments.length + " provided");
        for (int i = 0; i < arguments.length; i++) {
            Assertion.asserts(function.getParamType(i).compatible(arguments[i].getResultType()),
                    function.getName() + "'s parameter " + i + " requires " + function.getParamType(i) + ", but "
                            + arguments[i].getResultType() + " provided");
        }
    }

    @Override
    public Expr[] children() {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(function.getName());
        sb.append("(");
        for (int i = 0; i < arguments.length; i++) {
            sb.append(arguments[i]);
            if (i < arguments.length - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        FunctionCall other = (FunctionCall) obj;
        if (!Arrays.equals(arguments, other.arguments))
            return false;
        if (function == null) {
            if (other.function != null)
                return false;
        } else if (!function.equals(other.function))
            return false;
        return true;
    }

    @Override
    public Expr withChildren(Expr... children) {
        return new FunctionCall(function, children);
    }

}
