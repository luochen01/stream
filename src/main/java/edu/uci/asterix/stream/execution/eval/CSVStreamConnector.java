package edu.uci.asterix.stream.execution.eval;

import java.io.FileInputStream;
import java.io.IOException;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.reader.CSVReader;
import edu.uci.asterix.stream.execution.reader.ITupleReader;
import edu.uci.asterix.stream.field.StructType;

public class CSVStreamConnector implements IStreamConnector {

    private ITupleReader csvReader;

    private final String file;

    public CSVStreamConnector(String file) {
        this.file = file;
    }

    @Override
    public void initialize(StructType sourceSchema, StructType outputSchema) throws Exception {
        this.csvReader = new CSVReader(sourceSchema, outputSchema, new FileInputStream(file));

    }

    @Override
    public Tuple next() {
        if (csvReader == null) {
            throw new IllegalStateException("Connector has not been initialized");
        }
        return csvReader.nextTuple();

    }

    @Override
    public void close() throws IOException {
        if (csvReader != null) {
            csvReader.close();
        }
    };

}
