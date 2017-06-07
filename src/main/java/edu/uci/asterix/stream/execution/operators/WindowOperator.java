package edu.uci.asterix.stream.execution.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.asterix.stream.conf.StreamConfig;
import edu.uci.asterix.stream.execution.SystemTimeProvider;
import edu.uci.asterix.stream.execution.Tuple;
import edu.uci.asterix.stream.expr.Window;
import edu.uci.asterix.stream.expr.fields.FieldAccess;
import edu.uci.asterix.stream.field.StructType;
import edu.uci.asterix.stream.logical.LogicalStreamScan;
import edu.uci.asterix.stream.utils.Utils;

/**
 * stream definition -> stream
 *
 * @author luochen
 */
public class WindowOperator extends AbstractStreamOperator<LogicalStreamScan> {

    protected Logger logger = LoggerFactory.getLogger(WindowOperator.class);

    protected final Window window;

    protected final Operator child;

    protected final Queue<Tuple> bufferQueue = new ConcurrentLinkedQueue<>();

    protected final Thread intakeThread;

    protected final SystemTimeProvider timeProvider;

    protected final FieldAccess timeFieldAccessor;

    /**
     * Records the begin timestamp and end timestamp of sliding window.
     * Every time when the thread awakes, slideTimestampEnd is set as
     * (slideTimestampEnd + slide)
     * while slideTimestampBegin is set as slideTimestampEnd - window.range
     */
    protected volatile long slideTimestampBegin = -1;

    protected volatile long slideTimestampEnd = -1;

    /**
     * Records the begin timestamp of the next sliding window.
     * All tuples with timestamp < nextSliceTimestampBegin can be safely removed.
     */
    protected volatile long nextSlideTimestampBegin = -1;

    protected long processBegin;

    protected boolean needSleep = false;

    protected boolean initialized = false;

    protected int consumedTuples = 0;

    protected Iterator<Tuple> iterator;

    protected StructType schema;

    protected String currentWindow;

    public WindowOperator(Operator child, LogicalStreamScan logicalStreamScan, SystemTimeProvider timeProvider) {
        super(logicalStreamScan);
        this.child = child;
        this.window = logicalStreamScan.getWindow();
        this.timeProvider = timeProvider;

        this.timeFieldAccessor = new FieldAccess(
                this.getSchema().getField(StreamConfig.Instance.streamTimeField(), true), this.getSchema());

        /**
         * This thread keeps fetching tuples from child,
         * and stores the tuples in bufferQueue
         *
         * @author luochen
         */
        this.intakeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Tuple tuple = null;
                //retrieve the first tuple
                while ((tuple = child.next()) != null && slideTimestampEnd == -1) {
                    long timestamp = getTupleTimestamp(tuple);
                    slideTimestampEnd = timestamp;
                }
                logger.info("Stream slide window begins at {}", Utils.getTimeString(slideTimestampEnd * 1000));

                synchronized (WindowOperator.this) {
                    WindowOperator.this.notifyAll();
                }

                while ((tuple = child.next()) != null) {
                    long timestamp = getTupleTimestamp(tuple);
                    while (timestamp > slideTimestampEnd + window.getSlide()) {
                        synchronized (WindowOperator.this) {
                            try {
                                logger.info("Intake thread starts to sleep, since {} exceeds the next slide window...",
                                        Utils.getTimeString(timestamp * 1000));
                                WindowOperator.this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (timestamp >= nextSlideTimestampBegin) {
                        bufferQueue.add(tuple);
                    }
                }
            }
        });

    }

    @Override
    public void reset() {
        //do nothing
    }

    @Override
    public void initialize() {
        if (initialized) {
            return;
        }

        this.initialized = true;
        this.child.initialize();

        this.intakeThread.start();

        this.processBegin = timeProvider.currentTimeMillis();
        logger.info("Start waiting for the first stream tuple to come...");
        //first tuple has not come...
        while (slideTimestampEnd == -1) {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        sleep();
        internalReset();
    }

    @Override
    public Tuple next() {
        if (needSleep) {
            logger.info("Consumed {} tuples between slide window {} to {}", consumedTuples,
                    Utils.getTimeString((slideTimestampEnd - window.getSlide()) * 1000),
                    Utils.getTimeString(slideTimestampEnd * 1000));
            sleep();
            internalReset();
        }

        while (iterator.hasNext()) {
            consumedTuples++;
            Tuple tuple = iterator.next();
            long tupleTimestamp = getTupleTimestamp(tuple);
            if (tupleTimestamp == -1) {
                iterator.remove();
                continue;
            }
            if (tupleTimestamp > slideTimestampEnd) {
                //the current tuple exceeds the slide window
                break;
            }

            if (tupleTimestamp < nextSlideTimestampBegin) {
                //the current tuple can be deleted
                iterator.remove();
            }

            if (tupleTimestamp >= slideTimestampBegin && tupleTimestamp <= slideTimestampEnd) {
                //the current tuple lies in the slide window
                return tuple;
            }
        }
        //queue is empty now
        needSleep = true;
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

    public int getBufferSize() {
        return bufferQueue.size();
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

    protected void sleep() {
        long nextSlidetimestampEnd = slideTimestampEnd + window.getSlide();
        logger.info("Notify intake thread for the next time window {} to {}",
                Utils.getTimeString(slideTimestampEnd * 1000), Utils.getTimeString(nextSlidetimestampEnd * 1000));
        synchronized (this) {
            this.notifyAll();
        }
        try {
            long processEnd = timeProvider.currentTimeMillis();
            long sleepTime = window.getSlide() * 1000 - (processEnd - processBegin);
            if (sleepTime > 0) {
                logger.warn("Window Operator is about to sleep for {}ms", sleepTime);
                Thread.sleep(sleepTime);
            } else {
                logger.warn("Window Operator is lagged for {}ms", sleepTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reset is called after each sleep (when the operator is able to produce another table)
     */
    protected void internalReset() {
        needSleep = false;
        slideTimestampEnd = slideTimestampEnd + window.getSlide();
        slideTimestampBegin = slideTimestampEnd - window.getRange();
        nextSlideTimestampBegin = slideTimestampBegin + window.getSlide();
        processBegin = timeProvider.currentTimeMillis();
        consumedTuples = 0;

        currentWindow = "[" + Utils.getTimeString(slideTimestampBegin * 1000) + ","
                + Utils.getTimeString(slideTimestampEnd * 1000) + "]";

        iterator = bufferQueue.iterator();
    }

    protected long getTupleTimestamp(Tuple tuple) {
        String timeString = (String) timeFieldAccessor.eval(tuple);
        long timestamp = Utils.getTimestamp(timeString);
        if (timestamp == -1) {
            logger.error("Ignored illegal timestamp {}", timeString);
            return timestamp;
        } else {
            return timestamp / 1000;
        }
    }

    @Override
    public String getWindow() {
        return currentWindow;
    }
}
