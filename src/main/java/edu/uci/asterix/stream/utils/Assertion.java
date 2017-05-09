package edu.uci.asterix.stream.utils;

import edu.uci.asterix.stream.parser.ParsingException;

public class Assertion {

    public static void asserts(boolean cond, String msg) {
        if (!cond) {
            throw new ParsingException(msg);
        }
    }

    public static void asserts(boolean cond) {
        if (!cond) {
            throw new ParsingException("Assertion Error");
        }
    }

}
