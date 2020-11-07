package com.sinch.algorithm.exception;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
public class PolishNotationException extends RuntimeException {
    public PolishNotationException(String message, Exception e) {
        super(message, e);
    }

    public PolishNotationException(String message) {
        this(message, null);
    }
}
