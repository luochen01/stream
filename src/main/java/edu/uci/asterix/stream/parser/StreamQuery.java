package edu.uci.asterix.stream.parser;

import edu.uci.asterix.stream.logical.LogicalPlan;

public class StreamQuery {

    private final LogicalPlan plan;

    public StreamQuery(LogicalPlan plan) {
        this.plan = plan;
    }

    public LogicalPlan getLogicalPlan() {
        return plan;
    }
}
