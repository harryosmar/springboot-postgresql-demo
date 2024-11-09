package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {
    public UserNotFoundException() {
        super("user not found", HttpStatus.BAD_REQUEST, "ERRUSR4040");
    }
}
