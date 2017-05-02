package edu.uci.asterix.stream.func;

import edu.uci.asterix.stream.field.FieldType;
import edu.uci.asterix.stream.utils.Assertion;

public abstract class Function2 extends AbstractFunction {

    protected FieldType type0;

    protected FieldType type1;

    public Function2(String name) {
        super(name);
    }

    @Override
    public int numParams() {
        return 2;
    }

    @Override
    public FieldType getParamType(int i) {
        Assertion.asserts(i == 0 || i == 1);
        if (i == 0) {
            return type0;
        } else {
            return type1;
        }
    }

}
