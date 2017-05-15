package edu.uci.asterix.stream.function;

import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class Function1 extends AbstractFunction {

    protected final FieldType type;

    public Function1(String name, FieldType type) {
        super(name);
        this.type = type;
    }

    @Override
    public int numParams() {
        return 1;
    }

    @Override
    public FieldType getParamType(int i) {
        Assertion.asserts(i == 0);
        return type;
    }

    @Override
    public Object eval(Object... params) {
        Assertion.asserts(params.length == 1);
        return eval(params[0]);
    }

    public abstract Object eval(Object param);
}
