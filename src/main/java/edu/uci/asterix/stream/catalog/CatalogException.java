package edu.uci.asterix.stream.catalog;

public class CatalogException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CatalogException(String msg) {
        super(msg);
    }

    public CatalogException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
