package com.bigfishgames.gaeskeleton.exception;

/**
 * Represents an error encountered while calling a separate API
 */
public class ApiException extends Exception {
    public ApiException(String message) {
        super(message);
    }
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
    public ApiException(Throwable cause) {
        super(cause);
    }
}
