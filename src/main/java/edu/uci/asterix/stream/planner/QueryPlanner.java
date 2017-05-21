package edu.uci.asterix.stream.planner;

import edu.uci.asterix.stream.catalog.Table;
import edu.uci.asterix.stream.execution.DefaultSystemTimeProvider;
import edu.uci.asterix.stream.execution.operators.FilterOperator;
import edu.uci.asterix.stream.execution.operators.GroupbyOperator;
import edu.uci.asterix.stream.execution.operators.HashJoinOperator;
import edu.uci.asterix.stream.execution.operators.LimitOperator;
import edu.uci.asterix.stream.execution.operators.LoopJoinOperator;
import edu.uci.asterix.stream.execution.operators.Operator;
import edu.uci.asterix.stream.execution.operators.ProjectOperator;
import edu.uci.asterix.stream.execution.operators.SensorToObservationStreamOperator;
import edu.uci.asterix.stream.execution.operators.SortOperator;
import edu.uci.asterix.stream.execution.operators.TableScanOperator;
import edu.uci.asterix.stream.execution.operators.WindowOperator;
import edu.uci.asterix.stream.logical.BinaryLogicalPlan;
import edu.uci.asterix.stream.logical.LogicalFilter;
import edu.uci.asterix.stream.logical.LogicalGroupby;
import edu.uci.asterix.stream.logical.LogicalJoin;
import edu.uci.asterix.stream.logical.LogicalLimit;
import edu.uci.asterix.stream.logical.LogicalPlan;
import edu.uci.asterix.stream.logical.LogicalProject;
import edu.uci.asterix.stream.logical.LogicalScan;
import edu.uci.asterix.stream.logical.LogicalSensorScan;
import edu.uci.asterix.stream.logical.LogicalSort;
import edu.uci.asterix.stream.logical.LogicalStreamScan;
import edu.uci.asterix.stream.logical.LogicalTableScan;
import edu.uci.asterix.stream.logical.UnaryLogicalPlan;

/**
 * Logical Plan -> Operators
 *
 * @author luochen
 */
public class QueryPlanner {

    public static final QueryPlanner INSTANCE = new QueryPlanner();

    private QueryPlanner() {

    }

    public Operator plan(LogicalPlan plan) {
        if (plan instanceof BinaryLogicalPlan) {
            return planBinary((BinaryLogicalPlan) plan);
        } else if (plan instanceof UnaryLogicalPlan) {
            return planUnary((UnaryLogicalPlan) plan);
        } else if (plan instanceof LogicalScan<?>) {
            return planScan((LogicalScan<?>) plan);
        }
        throw new IllegalArgumentException("Unknown LogicalPlan " + plan);
    }

    private Operator planBinary(BinaryLogicalPlan plan) {
        Operator left = plan(plan.getLeft());
        Operator right = plan(plan.getRight());
        if (plan instanceof LogicalJoin) {
            LogicalJoin join = (LogicalJoin) plan;
            if (join.isEquiJoin()) {
                return new HashJoinOperator(left, right, join);
            } else {
                return new LoopJoinOperator(left, right, join);
            }
        }
        throw new IllegalArgumentException("Unknown BinaryLogicalPlan " + plan);
    }

    private Operator planUnary(UnaryLogicalPlan plan) {
        Operator child = plan(plan.getChild());
        if (plan instanceof LogicalProject) {
            return new ProjectOperator(child, (LogicalProject) plan);
        } else if (plan instanceof LogicalFilter) {
            return new FilterOperator(child, (LogicalFilter) plan);
        } else if (plan instanceof LogicalGroupby) {
            return new GroupbyOperator(child, (LogicalGroupby) plan);
        } else if (plan instanceof LogicalSort) {
            return new SortOperator(child, (LogicalSort) plan);
        } else if (plan instanceof LogicalLimit) {
            return new LimitOperator(child, (LogicalLimit) plan);
        }
        throw new IllegalArgumentException("Unknown UnaryLogicalPlan " + plan);
    }

    private Operator planScan(LogicalScan<? extends Table> plan) {
        if (plan instanceof LogicalTableScan) {
            return new TableScanOperator((LogicalTableScan) plan);
        } else if (plan instanceof LogicalSensorScan) {
            LogicalSensorScan sensorScan = (LogicalSensorScan) plan;
            return plan(sensorScan.getTable().getLogicalPlan());
        } else if (plan instanceof LogicalStreamScan) {
            LogicalStreamScan streamScan = (LogicalStreamScan) plan;
            Operator child = plan(streamScan.getTable().getLogicalPlan());
            Operator streamOperator = new SensorToObservationStreamOperator(child, streamScan);
            Operator windowOperator = new WindowOperator(streamOperator, streamScan, new DefaultSystemTimeProvider());
            return windowOperator;
        }
        throw new IllegalArgumentException("Unknown LogicalScan " + plan);

    }
}
