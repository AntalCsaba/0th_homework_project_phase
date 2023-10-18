package com.example.calories.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MealExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(AddNotSuccessfullException addNotSuccessfullException){

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(addNotSuccessfullException.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

}
