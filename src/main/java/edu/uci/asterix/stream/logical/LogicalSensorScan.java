package edu.uci.asterix.stream.logical;

import edu.uci.asterix.stream.catalog.SensorCollection;

public class LogicalSensorScan extends LogicalScan<SensorCollection> {

    public LogicalSensorScan(SensorCollection table, String alias) {
        super(table, alias);
    }

    @Override
    public String getName() {
        return "SensorCollection";
    }

}
