package edu.uci.asterix.stream.logical;

import edu.uci.asterix.stream.field.StructType;

public abstract class LogicalPlan {

    public abstract StructType getSchema();

}
