package edu.uci.asterix.stream.execution.rules;

import org.apache.calcite.plan.Convention;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptCost;
import org.apache.calcite.plan.RelOptPlanner;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.convert.ConverterRule;
import org.apache.calcite.rel.core.Filter;
import org.apache.calcite.rel.logical.LogicalFilter;
import org.apache.calcite.rel.metadata.RelMetadataQuery;
import org.apache.calcite.rex.RexNode;

import edu.uci.asterix.stream.execution.operators.IStreamOperator;
import edu.uci.asterix.stream.execution.operators.StreamFilterOperator;

public class StreamFilter extends Filter implements StreamRel {

    protected StreamFilter(RelOptCluster cluster, RelNode child, RexNode condition) {
        super(cluster, cluster.traitSetOf(StreamConvention.INSTANCE), child, condition);
    }

    @Override
    public IStreamOperator implement() {
        IStreamOperator child = ((StreamRel) input).implement();
        return new StreamFilterOperator(child, condition);
    }

    @Override
    public double estimateRowCount(RelMetadataQuery mq) {
        return mq.getRowCount(input) * 0.1;
    }

    @Override
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
        double dRows = mq.getRowCount(getInput());
        //a hack to force Project first
        double dCpu = dRows * input.getRowType().getFieldCount();
        double dIo = 0;
        return planner.getCostFactory().makeCost(dRows, dCpu, dIo);
    }

    @Override
    public Filter copy(RelTraitSet traitSet, RelNode input, RexNode condition) {
        return new StreamFilter(getCluster(), input, condition);
    }

    public static class StreamFilterRule extends ConverterRule {
        public static final StreamFilterRule INSTANCE = new StreamFilterRule();

        private StreamFilterRule() {
            super(LogicalFilter.class, Convention.NONE, StreamConvention.INSTANCE, "StreamFilterRule");
        }

        @Override
        public RelNode convert(RelNode rel) {
            final LogicalFilter filter = (LogicalFilter) rel;
            return new StreamFilter(rel.getCluster(),
                    convert(filter.getInput(), filter.getInput().getTraitSet().replace(StreamConvention.INSTANCE)),
                    filter.getCondition());
        }

    }
}
