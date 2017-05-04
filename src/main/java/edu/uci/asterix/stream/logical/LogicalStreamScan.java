package edu.uci.asterix.stream.logical;

import java.util.List;
import java.util.stream.Collectors;

import edu.uci.asterix.stream.expr.Window;
import edu.uci.asterix.stream.field.Field;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.parser.ObservationStream;

public class LogicalStreamScan extends LeafLogicalPlan {

    private final ObservationStream stream;

    private final Window window;

    private final StructType schema;

    public LogicalStreamScan(ObservationStream stream, Window window, String streamAlias) {
        this.stream = stream;
        this.window = window;

        List<Field> fields = stream.getFields().stream().map(field -> field.withTableAlias(streamAlias))
                .collect(Collectors.toList());
        schema = new StructType(fields);
    }

    @Override
    public StructType getSchema() {
        return schema;
    }

    @Override
    public String getName() {
        return "STREAM";
    }

    public Window getWindow() {
        return window;
    }

    @Override
    protected void printContent(StringBuilder sb) {
        sb.append(stream.getTableName());
    }

}
