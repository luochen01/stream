package edu.uci.asterix.stream.parser;

import java.util.HashMap;
import java.util.Map;

import edu.uci.asterix.stream.catalog.ObservationStream;
import edu.uci.asterix.stream.catalog.SensorCollection;

/**
 * Provides necessary information for processing a query
 * 
 * @author luochen
 */
public class QueryContext {

    private Map<String, SensorCollection> sensorCollections = new HashMap<>();

    private Map<String, ObservationStream> streams = new HashMap<>();

    private StreamQuery query;

    public QueryContext() {
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

}
