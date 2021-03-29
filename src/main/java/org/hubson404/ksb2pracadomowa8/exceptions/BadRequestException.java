package org.hubson404.ksb2pracadomowa8.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super("BAD REQUEST: " + message);
    }
}
