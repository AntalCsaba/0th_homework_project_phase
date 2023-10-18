package com.example.calories.errors;

public class AddNotSuccessfullException extends RuntimeException{

    public AddNotSuccessfullException(String message) {
        super(message);
    }

    public AddNotSuccessfullException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddNotSuccessfullException(Throwable cause) {
        super(cause);
    }
}
