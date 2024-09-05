package com.acejsaul.ApiLibrary.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

    private Instant exceptionTime = Instant.now();
    private Integer errorStatus;
    private String error;
    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(Integer errorStatus, String error, String message, String path) {
        this.errorStatus = errorStatus;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getExceptionTime() {
        return exceptionTime;
    }

    public void setExceptionTime(Instant exceptionTime) {
        this.exceptionTime = exceptionTime;
    }

    public Integer getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(Integer errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
