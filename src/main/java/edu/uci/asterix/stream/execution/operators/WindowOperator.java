package edu.uci.asterix.stream.execution.operators;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Window;
import edu.uci.asterix.stream.logical.LogicalStreamScan;

/**
 * stream definition -> stream
 *
 * @author luochen
 */
public class WindowOperator extends AbstractStreamOperator<LogicalStreamScan> {

    protected final Window window;

    protected final Operator child;

    public WindowOperator(Operator child, LogicalStreamScan logicalStreamScan) {
        super(logicalStreamScan);
        this.child = child;
        this.window = logicalStreamScan.getWindow();
    }

    @Override
    public Tuple next() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Operator[] children() {
        return new Operator[] { child };
    }

    @Override
    public String getName() {
        return "WINDOW";
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append("range:");
        sb.append(window.getRange());
        sb.append("s,");
        sb.append("slide:");
        sb.append(window.getSlide());
        sb.append("s");
    }

}
