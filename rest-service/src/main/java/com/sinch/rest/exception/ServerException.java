package com.sinch.rest.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
public class ServerException extends RuntimeException {

    private final HttpStatus httpStatus;

    public ServerException(HttpStatus httpStatus, String message, Exception e) {
        super(message, e);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
