package edu.uci.asterix.stream.execution.rules;

import org.apache.calcite.rel.convert.ConverterRule;

import edu.uci.asterix.stream.execution.rules.StreamProject.StreamProjectRule;

public class StreamConverterRules {
    public static final ConverterRule[] RULES = new ConverterRule[] { StreamProjectRule.INSTANCE };

}
