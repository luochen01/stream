package edu.uci.asterix.stream.function;

import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class Function0 extends AbstractFunction {

    public Function0(String name) {
        super(name);
    }

    @Override
    public int numParams() {
        return 0;
    }

    @Override
    public FieldType getParamType(int i) {
        return null;
    }

    @Override
    public Object eval(Object... params) {
        Assertion.asserts(params.length == 0);
        return eval();
    }

    public abstract Object eval();
}
