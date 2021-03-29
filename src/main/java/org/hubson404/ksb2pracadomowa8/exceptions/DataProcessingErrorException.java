package org.hubson404.ksb2pracadomowa8.exceptions;

public class DataProcessingErrorException extends RuntimeException {

    public DataProcessingErrorException(String message) {
        super("DATA PROCESSING ERROR: " + message);
    }
}
