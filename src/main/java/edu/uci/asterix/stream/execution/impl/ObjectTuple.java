package edu.uci.asterix.stream.execution.impl;

import java.util.Arrays;

import com.google.common.base.Preconditions;

import edu.uci.asterix.stream.execution.ITuple;

public class ObjectTuple implements ITuple {

    private final Object[] fields;

    public ObjectTuple(Object[] fields) {
        this.fields = fields;
    }

    @Override
    public int numFields() {
        return fields.length;
    }

    @Override
    public byte[] readField(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object readFieldObject(int i) {
        Preconditions.checkElementIndex(i, fields.length);
        return fields[i];
    }

    @Override
    public String toString() {
        return Arrays.toString(fields);
    }

}
