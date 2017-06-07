package edu.uci.asterix.stream.api;

public class StreamDemo {

    private final static String sensorQuery = "src/main/resources/query/sensor.tql";

    private final static String coverageQuery = "src/main/resources/query/sensor_coverage.tql";

    private final static String userQuery = "src/main/resources/query/user.tql";

    public static void main(String[] args) {
        StreamApp.main(new String[] { coverageQuery });
        StreamApp.main(new String[] { sensorQuery });
        StreamApp.main(new String[] { userQuery });
    }
}
