package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class UsernameNotAvailableException extends CustomException {
    public UsernameNotAvailableException() {
        super("username is not available", HttpStatus.BAD_REQUEST, "ERR4001");
    }
}
