package edu.uci.asterix.stream.execution.operators;

import java.util.Iterator;
import java.util.List;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.operators.Operator;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalPlan;

public class ListOperator implements Operator {

    private final StructType schema;

    private final Iterator<Tuple> iterator;

    public ListOperator(StructType schema, List<Tuple> list) {
        this.schema = schema;
        this.iterator = list.iterator();
    }

    @Override
    public Tuple next() {
        if (iterator.hasNext()) {
            return iterator.next();
        } else {
            return null;
        }
    }

    @Override
    public StructType getSchema() {
        return schema;
    }

    @Override
    public LogicalPlan getLogicalPlan() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Operator[] children() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getName() {
        return "LIST OPERATOR";
    }

    @Override
    public void reset() {
    }

    @Override
    public void initialize() {
    }

    @Override
    public void print(StringBuilder sb, int level) {
        throw new UnsupportedOperationException();
    }

}
