package edu.hw2.Task3.exception;

import java.io.Serial;

public class ConnectionException extends RuntimeException {
    @Serial private static final long serialVersionUID = 1L; // Add this line

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
