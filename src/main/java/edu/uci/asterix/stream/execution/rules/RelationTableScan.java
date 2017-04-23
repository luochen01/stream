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

import edu.uci.asterix.stream.catalog.RelationTable;
import edu.uci.asterix.stream.execution.operators.IStreamOperator;
import edu.uci.asterix.stream.execution.operators.RelationScanOperator;

public class RelationTableScan extends TableScan implements StreamRel {

    protected final RelationTable relationTable;

    public RelationTableScan(RelOptCluster cluster, RelOptTable table, RelationTable relationTable) {
        super(cluster, cluster.traitSetOf(StreamConvention.INSTANCE), table);
        this.relationTable = relationTable;
        assert getConvention() instanceof StreamConvention;
    }

    @Override
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
        assert inputs.isEmpty();
        return new RelationTableScan(this.getCluster(), table, relationTable);
    }

    @Override
    public IStreamOperator implement() {
        return new RelationScanOperator(relationTable);
    }

    @Override
    public double estimateRowCount(RelMetadataQuery mq) {
        return 100;
    }

    public static class RelationTableScanRule extends ConverterRule {
        public static final RelationTableScanRule INSTANCE = new RelationTableScanRule();

        private RelationTableScanRule() {
            super(LogicalTableScan.class, Convention.NONE, StreamConvention.INSTANCE, "RelationTableScanRule");
        }

        @Override
        public RelNode convert(RelNode rel) {
            LogicalTableScan scan = (LogicalTableScan) rel;
            RelationTable relationTable = scan.getTable().unwrap(RelationTable.class);
            if (relationTable != null) {
                return new RelationTableScan(rel.getCluster(), scan.getTable(), relationTable);
            } else {
                return null;
            }

        }

    }
}
