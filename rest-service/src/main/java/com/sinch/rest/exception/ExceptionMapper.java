package com.sinch.rest.exception;

import com.sinch.rest.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Jonathan Schurmann on 11/7/20.
 */
@RestControllerAdvice
public class ExceptionMapper extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ServerException.class)
    public final ResponseEntity<ErrorResponse> handleException(ServerException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), ex.getHttpStatus());
    }

}
