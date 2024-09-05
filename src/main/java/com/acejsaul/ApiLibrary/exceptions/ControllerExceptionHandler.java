package com.acejsaul.ApiLibrary.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<StandardError> argumentTypeMismatch(BadRequest e, HttpServletRequest request){
        String error = "Invalid Argument";
        int status = HttpStatus.BAD_REQUEST.value();
        StandardError exception = new StandardError(status, error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(exception);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFound e, HttpServletRequest request){
        String error = "Resource not found in DB.";
        int status = HttpStatus.NOT_FOUND.value();
        StandardError exception = new StandardError(status, error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(exception);
    }
}
