package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalPlan;

public interface Operator {

    /**
     * @return next tuple, or null if the operator is finished
     */
    public Tuple next();

    /**
     * Each operator should have an output schema, i.e., specify the schema of its output tuples
     * 
     * @return
     */
    public StructType getSchema();

    public LogicalPlan getLogicalPlan();

    public Operator[] children();

    public String getName();

    public String toString();

    public void print(StringBuilder sb, int level);

}