package com.example.calories.exceptions;

public class MealNotFoundException extends RuntimeException{

    public MealNotFoundException(String message) {
        super(message);
    }

    public MealNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MealNotFoundException(Throwable cause) {
        super(cause);
    }
}
