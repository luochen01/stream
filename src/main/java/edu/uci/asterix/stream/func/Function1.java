package edu.uci.asterix.stream.func;

import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class Function1 extends AbstractFunction {

    protected FieldType type;

    public Function1(String name) {
        super(name);
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

}
