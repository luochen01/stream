package edu.uci.asterix.stream.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import edu.uci.asterix.stream.conf.StreamConfig;

public class Utils {

    private final static SimpleDateFormat timeFormat = new SimpleDateFormat(StreamConfig.Instance.streamTimeFormat(),
            Locale.US);

    public static <T> String format(Collection<T> list, String delim) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (T ele : list) {
            sb.append(ele.toString());
            if (count++ < list.size() - 1) {
                sb.append(delim);
            }
        }
        return sb.toString();
    }

    public static long getTimestamp(String timestamp) {
        if (timestamp == null) {
            return -1;
        } else {
            try {
                return timeFormat.parse(timestamp).getTime();
            } catch (ParseException e) {
                return -1;
            }
        }
    }

    public static String getTimeString(long timestamp) {
        SimpleDateFormat format = new SimpleDateFormat(StreamConfig.Instance.streamTimeFormat(), Locale.US);
        Date date = new Date(timestamp);
        return format.format(date);
    }

}
