package edu.uci.asterix.stream.execution.rules;

import java.util.List;

import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.core.TableScan;

import edu.uci.asterix.stream.catalog.StreamTable;
import edu.uci.asterix.stream.execution.operators.IStreamOperator;
import edu.uci.asterix.stream.execution.operators.StreamScanOperator;

public class StreamTableScan extends TableScan implements StreamRel {

    protected final StreamTable streamTable;

    public StreamTableScan(RelOptCluster cluster, RelOptTable table, StreamTable streamTable) {
        super(cluster, cluster.traitSetOf(StreamConvention.INSTANCE), table);
        this.streamTable = streamTable;
        assert getConvention() instanceof StreamConvention;
    }

    @Override
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
        assert inputs.isEmpty();
        return new StreamTableScan(this.getCluster(), table, streamTable);
    }

    @Override
    public IStreamOperator implement() {
        return new StreamScanOperator(streamTable);
    }

}
