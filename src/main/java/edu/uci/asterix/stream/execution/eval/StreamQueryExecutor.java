package edu.uci.asterix.stream.execution.eval;

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.execution.operators.Operator;
import edu.uci.asterix.stream.execution.writer.ITupleWriter;

public class StreamQueryExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamQueryExecutor.class);

    public static final StreamQueryExecutor INSTANCE = new StreamQueryExecutor();

    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100, 60, TimeUnit.SECONDS,
            new SynchronousQueue<>());

    public void asyncExecute(Operator root, ITupleWriter writer) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                execute(root, writer);
            }
        });
    }

    public void syncExecute(Operator root, ITupleWriter writer) {
        execute(root, writer);
    }

    private void execute(Operator root, ITupleWriter writer) {
        while (true) {
            root.initialize();
            Tuple tuple;
            while ((tuple = root.next()) != null) {
                try {
                    writer.write(tuple);
                } catch (IOException e) {
                    LOGGER.error("Fail to write tuple");
                }
            }
            root.reset();
        }
    }

}
