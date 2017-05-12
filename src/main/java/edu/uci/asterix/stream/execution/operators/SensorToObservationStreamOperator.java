package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.catalog.ObservationStream;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.logical.LogicalStreamScan;

/**
 * For this operator, I think it should first collect all data from the underling sensor (by executing the child operator),
 * and then push streams upwards
 *
 * @author luochen
 */
public class SensorToObservationStreamOperator extends AbstractStreamOperator<LogicalStreamScan> {

    protected final ObservationStream stream;

    protected final Operator child;

    public SensorToObservationStreamOperator(Operator child, LogicalStreamScan logicalScan) {
        super(logicalScan);
        this.child = child;
        this.stream = logicalScan.getTable();
    }

    @Override
    public Operator[] children() {
        return new Operator[] { child };
    }

    @Override
    public String getName() {
        return "SensorToObservationStream";
    }

    @Override
    public Tuple next() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(stream.getTableName());
        if (!logicalPlan.getAlias().equals(stream.getTableName())) {
            sb.append(" AS ");
            sb.append(logicalPlan.getAlias());
        }
    }

}
