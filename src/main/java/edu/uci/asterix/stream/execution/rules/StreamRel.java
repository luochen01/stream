package edu.uci.asterix.stream.execution.rules;

import org.apache.calcite.rel.RelNode;

import edu.uci.asterix.stream.execution.operators.IStreamOperator;

public interface StreamRel extends RelNode {

    IStreamOperator implement();
}
