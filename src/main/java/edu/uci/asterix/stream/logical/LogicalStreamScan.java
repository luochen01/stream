package edu.uci.asterix.stream.logical;

import edu.uci.asterix.stream.catalog.ObservationStream;
import edu.uci.asterix.stream.conf.StreamConfig;
import edu.uci.asterix.stream.expr.Window;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.utils.Assertion;

public class LogicalStreamScan extends LogicalScan<ObservationStream> {

    private final Window window;

    public LogicalStreamScan(ObservationStream stream, Window window, String alias) {
        super(stream, alias);
        this.window = window;

        Assertion.asserts(window.getRange() >= window.getSlide(),
                "RANGE should be no less than SLIDE in stream operator");

        Field timeField = stream.getSchema().getField(StreamConfig.Instance.streamTimeField());
        //TODO: currently this would fail the schema because we do not know how to obtain streams
        Assertion.asserts(timeField != null,
                "Required time field " + StreamConfig.Instance.streamTimeField() + " is not found in stream schema");
    }

    @Override
    public String getName() {
        return "SensorsToObservationStream";
    }

    public Window getWindow() {
        return window;
    }

}
