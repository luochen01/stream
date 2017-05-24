package edu.uci.asterix.stream.execution;

import java.util.Arrays;

import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.utils.Assertion;

public class Tuple {

    public static Tuple merge(Tuple left, Tuple right, StructType resultSchema) {
        Object[] values = new Object[left.values.length + right.values.length];
        int index = 0;
        for (Object value : left.values) {
            values[index++] = value;
        }
        for (Object value : right.values) {
            values[index++] = value;
        }
        return new Tuple(resultSchema, values);
    }

    protected final Object[] values;

    protected final StructType schema;

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

    public StructType getSchema() {
        return schema;
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
