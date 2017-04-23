package edu.uci.asterix.stream.execution.rules;

import org.apache.calcite.rel.convert.ConverterRule;

import edu.uci.asterix.stream.execution.rules.RelationTableScan.RelationTableScanRule;
import edu.uci.asterix.stream.execution.rules.StreamFilter.StreamFilterRule;
import edu.uci.asterix.stream.execution.rules.StreamProject.StreamProjectRule;
import edu.uci.asterix.stream.execution.rules.StreamTableScan.StreamTableScanRule;

public class StreamConverterRules {
    public static final ConverterRule[] RULES = new ConverterRule[] { RelationTableScanRule.INSTANCE,
            StreamTableScanRule.INSTANCE, StreamProjectRule.INSTANCE, StreamFilterRule.INSTANCE };

}
