package edu.uci.asterix.stream.field;

public enum FieldTypeName {
    //java string
    STRING,
    //java double
    REAL,
    //java int
    INTEGER,
    //java boolean
    BOOLEAN,
    //java object[]
    ARRAY,
    //java object[]
    STRUCT;

    public boolean isNumerical() {
        return this == REAL || this == INTEGER;
    }

}
