package edu.uci.asterix.stream.execution.rules;

import java.util.List;

import org.apache.calcite.plan.Convention;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.convert.ConverterRule;
import org.apache.calcite.rel.core.TableScan;
import org.apache.calcite.rel.logical.LogicalTableScan;
import org.apache.calcite.rel.metadata.RelMetadataQuery;

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

    @Override
    public double estimateRowCount(RelMetadataQuery mq) {
        return 100;
    }

    public static class StreamTableScanRule extends ConverterRule {
        public static final StreamTableScanRule INSTANCE = new StreamTableScanRule();

        private StreamTableScanRule() {
            super(LogicalTableScan.class, Convention.NONE, StreamConvention.INSTANCE, "StreamTableScanRule");
        }

        @Override
        public RelNode convert(RelNode rel) {
            final LogicalTableScan scan = (LogicalTableScan) rel;
            StreamTable streamTable = scan.getTable().unwrap(StreamTable.class);
            if (streamTable != null) {
                return new StreamTableScan(rel.getCluster(), scan.getTable(), null);
            } else {
                return null;
            }

        }

    }
}
