package edu.uci.asterix.stream.exception;

public class StreamExecutionException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public StreamExecutionException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public StreamExecutionException(String msg) {
        super(msg);
    }

}
