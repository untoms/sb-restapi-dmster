package com.example.springbootrest.exceptions;

public class UserNameNotFoundException extends Exception  {
    public UserNameNotFoundException(String message) {
        super(message);
    }
}
