package edu.uci.asterix.stream.logical;

import edu.uci.asterix.stream.catalog.ObservationStream;
import edu.uci.asterix.stream.expr.Window;

public class LogicalStreamScan extends LogicalScan<ObservationStream> {

    private final Window window;

    public LogicalStreamScan(ObservationStream stream, Window window, String alias) {
        super(stream, alias);
        this.window = window;
    }

    @Override
    public String getName() {
        return "SensorsToObservationStream";
    }

    public Window getWindow() {
        return window;
    }

}
