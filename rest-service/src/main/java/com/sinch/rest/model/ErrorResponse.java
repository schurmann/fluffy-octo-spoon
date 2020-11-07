package com.sinch.rest.model;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
public class ErrorResponse {
    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
