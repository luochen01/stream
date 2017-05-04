package edu.uci.asterix.stream.utils;

import java.util.Collection;

public class Utils {

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

}
