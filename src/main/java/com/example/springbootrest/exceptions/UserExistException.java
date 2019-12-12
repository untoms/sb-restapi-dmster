package com.example.springbootrest.exceptions;

public class UserExistException extends Exception {

    public UserExistException(String message) {
        super(message);
    }
}
