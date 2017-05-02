package edu.uci.asterix.stream.utils;

public class Assertion {

    public static void asserts(boolean cond, String msg) {
        if (!cond) {
            throw new AssertionError(msg);
        }
    }

    public static void asserts(boolean cond) {
        if (!cond) {
            throw new AssertionError();
        }
    }

}
