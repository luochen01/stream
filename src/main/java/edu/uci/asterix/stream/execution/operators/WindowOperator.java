package edu.uci.asterix.stream.execution.operators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
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

    protected final SimpleDateFormat timeFormat = new SimpleDateFormat(StreamConfig.Instance.streamTimeFormat(),
            Locale.US);

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
    protected long nextSliceTimestampBegin;

    protected boolean needSleep = false;

    protected Iterator<Tuple> iterator;

    public WindowOperator(Operator child, LogicalStreamScan logicalStreamScan, SystemTimeProvider timeProvider) {
        super(logicalStreamScan);
        this.child = child;
        this.window = logicalStreamScan.getWindow();
        this.timeProvider = timeProvider;

        this.timeFieldAccessor = new FieldAccess(this.getSchema().getField(StreamConfig.Instance.streamTimeField()),
                this.getSchema());

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
        this.intakeThread.start();

        slideTimestampEnd = timeProvider.currentTimeMillis();
        sleep();
        reset();
    }

    @Override
    public Tuple next() {
        if (needSleep) {
            sleep();
            reset();
        }

        while (iterator.hasNext()) {
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

            if (tupleTimestamp < nextSliceTimestampBegin) {
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
        long nextSlidetimestampEnd = slideTimestampEnd + window.getSlide() * 1000;
        try {
            long currentTimestamp = timeProvider.currentTimeMillis();
            if (nextSlidetimestampEnd > currentTimestamp) {
                logger.info("Window Operator is about to sleep for {}ms", nextSlidetimestampEnd - currentTimestamp);
                Thread.sleep(nextSlidetimestampEnd - currentTimestamp);
            } else {
                logger.warn("Window Operator is lagged for {}ms", currentTimestamp - nextSlidetimestampEnd);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reset is called after each sleep (when the operator is able to produce another table)
     */
    protected void reset() {
        needSleep = false;
        slideTimestampEnd = slideTimestampEnd + window.getSlide() * 1000;
        slideTimestampBegin = slideTimestampEnd - window.getRange() * 1000;
        nextSliceTimestampBegin = slideTimestampBegin + window.getSlide() * 1000;

        iterator = bufferQueue.iterator();
    }

    protected long getTupleTimestamp(Tuple tuple) {
        String timestamp = (String) timeFieldAccessor.eval(tuple);
        if (timestamp == null) {
            return -1;
        } else {
            try {
                return timeFormat.parse(timestamp).getTime();
            } catch (ParseException e) {
                logger.error("Ignored illegal timestamp {}", timestamp);
                return -1;
            }
        }
    }

}
