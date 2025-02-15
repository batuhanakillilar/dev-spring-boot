package com.batu.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //Add exception handling code here

    //generic one
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e) {

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {

        //Create a student error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return responseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
