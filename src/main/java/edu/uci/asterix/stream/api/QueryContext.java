package edu.uci.asterix.stream.api;

import java.util.HashMap;
import java.util.Map;

import edu.uci.asterix.stream.catalog.ObservationStream;
import edu.uci.asterix.stream.catalog.SensorCollection;
import edu.uci.asterix.stream.parser.StreamQuery;

/**
 * Provides necessary information for processing a query
 *
 * @author luochen
 */
public class QueryContext {

    private final Map<String, SensorCollection> sensorCollections = new HashMap<>();

    private final Map<String, ObservationStream> streams = new HashMap<>();

    private StreamQuery query;

    private final IQueryConfig config;

    public QueryContext(IQueryConfig config) {
        this.config = config;
    }

    public void addSensorCollection(SensorCollection collection) {

        sensorCollections.put(collection.getTableName(), collection);
    }

    public SensorCollection getSensorCollection(String name) {
        return sensorCollections.get(name);
    }

    public void addObservationStream(ObservationStream stream) {
        streams.put(stream.getTableName(), stream);
    }

    public ObservationStream getObservationStream(String name) {
        return streams.get(name);
    }

    public StreamQuery getQuery() {
        return query;
    }

    public void setQuery(StreamQuery query) {
        this.query = query;
    }

    public IQueryConfig getConfig() {
        return config;
    }
}
