package com.batu.demo.rest;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message, Throwable cause) {

        super(message, cause);
    }
    public StudentNotFoundException(String message) {
        super(message);
    }


}
