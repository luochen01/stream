package edu.uci.asterix.stream.logical.analyzer;

import edu.uci.asterix.stream.logical.LogicalPlan;

public interface LogicalPlanAnalyzer {

    public LogicalPlan analyze(LogicalPlan plan);

}
