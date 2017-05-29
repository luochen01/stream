package edu.uci.asterix.stream.execution.operators;

import java.util.Arrays;

/**
 * Created by Gift_Sinthong on 5/28/17.
 */
public class GroupbyKey {
    Object[] keys;

    public GroupbyKey(Object[] keys) {
        this.keys = keys;
    }

    public Object[] getKeys() {
        return keys;
    }

    public void setKeys(Object[] keys) {
        this.keys = keys;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        GroupbyKey that = (GroupbyKey) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(keys, that.keys);
    }

    @Override public int hashCode() {
        return Arrays.hashCode(keys);
    }
}
