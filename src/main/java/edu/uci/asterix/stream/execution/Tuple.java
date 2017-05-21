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

    public Object[] getAllValues() {
        return values;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(values);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tuple other = (Tuple) obj;
        if (!Arrays.equals(values, other.values))
            return false;
        return true;
    }

}
