package com.example.calories.errors;

import com.example.calories.exceptions.AddNotSuccessfullException;
import com.example.calories.exceptions.MealNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MealExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAddException(AddNotSuccessfullException addNotSuccessfullException){

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(addNotSuccessfullException.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUpdateException(MealNotFoundException mealNotFoundException){

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(mealNotFoundException.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

}
