package edu.uci.asterix.stream.execution;

public interface ITuple {
    public int numFields();

    public byte[] readField(int i);

    public Object readFieldObject(int i);
}
