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
    protected long slideTimestampBegin;

    protected long slideTimestampEnd;

    /**
     * Records the begin timestamp of the next sliding window.
     * All tuples with timestamp < nextSliceTimestampBegin can be safely removed.
     */
    protected long nextSlideTimestampBegin;

    protected boolean needSleep = false;

    protected boolean initialized = false;

    protected int consumedTuples = 0;

    protected Iterator<Tuple> iterator;

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
                while ((tuple = child.next()) != null) {
                    bufferQueue.add(tuple);
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

        slideTimestampEnd = timeProvider.currentTimeMillis() / 1000;
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
        try {
            long currentTimestamp = timeProvider.currentTimeMillis() / 1000;
            if (nextSlidetimestampEnd > currentTimestamp) {
                logger.warn("Window Operator is about to sleep for {}s", nextSlidetimestampEnd - currentTimestamp);
                Thread.sleep((nextSlidetimestampEnd - currentTimestamp) * 1000);
            } else {
                logger.warn("Window Operator is lagged for {}s", currentTimestamp - nextSlidetimestampEnd);
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
        consumedTuples = 0;

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

}
