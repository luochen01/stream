package edu.uci.asterix.stream.execution;

import java.util.Arrays;

import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.utils.Assertion;

public class Tuple {

    private final Object[] values;

    private final StructType schema;

    public Tuple(StructType schema) {
        this.schema = schema;
        this.values = new Object[schema.getFieldCount()];
    }

    public Tuple(StructType schema, Object[] values) {
        this.schema = schema;
        this.values = values;
        Assertion.asserts(this.schema.getFieldCount() == values.length);
    }

    public int getFieldCount() {
        return values.length;
    }

    public Object get(int i) {
        return values[i];
    }

    public void set(int i, Object value) {
        values[i] = value;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

}
