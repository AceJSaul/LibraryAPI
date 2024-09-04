package com.acejsaul.ApiLibrary.exceptions;

public class BadRequest extends RuntimeException{

    public BadRequest(String message) {
        super(message);
    }
}
