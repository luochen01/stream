package edu.uci.asterix.stream.execution.rules;

import java.util.List;

import org.apache.calcite.plan.Convention;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptCost;
import org.apache.calcite.plan.RelOptPlanner;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.convert.ConverterRule;
import org.apache.calcite.rel.core.Project;
import org.apache.calcite.rel.logical.LogicalProject;
import org.apache.calcite.rel.metadata.RelMetadataQuery;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rex.RexNode;

import edu.uci.asterix.stream.execution.operators.IStreamOperator;
import edu.uci.asterix.stream.execution.operators.StreamProjectOperator;

public class StreamProject extends Project implements StreamRel {

    protected StreamProject(RelOptCluster cluster, RelNode input, List<? extends RexNode> projects,
            RelDataType rowType) {
        super(cluster, cluster.traitSetOf(StreamConvention.INSTANCE), input, projects, rowType);
    }

    @Override
    public Project copy(RelTraitSet traitSet, RelNode input, List<RexNode> projects, RelDataType rowType) {
        return new StreamProject(this.getCluster(), input, projects, rowType);
    }

    @Override
    public double estimateRowCount(RelMetadataQuery mq) {
        return input.estimateRowCount(mq);
    }

    @Override
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
        double dRows = mq.getRowCount(getInput());
        double dCpu = dRows * exps.size() / getInput().getRowType().getFieldCount();
        double dIo = 0;
        return planner.getCostFactory().makeCost(dRows, dCpu, dIo);
    }

    @Override
    public IStreamOperator implement() {
        IStreamOperator child = ((StreamRel) input).implement();
        return new StreamProjectOperator(child);
    }

    public static class StreamProjectRule extends ConverterRule {
        public static final StreamProjectRule INSTANCE = new StreamProjectRule();

        private StreamProjectRule() {
            super(LogicalProject.class, Convention.NONE, StreamConvention.INSTANCE, "StreamProjectRule");
        }

        @Override
        public RelNode convert(RelNode rel) {
            final LogicalProject project = (LogicalProject) rel;
            return new StreamProject(rel.getCluster(),
                    convert(project.getInput(), project.getInput().getTraitSet().replace(StreamConvention.INSTANCE)),
                    project.getProjects(), project.getRowType());

        }

    }
}
