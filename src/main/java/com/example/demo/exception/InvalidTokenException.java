package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class InvalidTokenException extends CustomException {
    public InvalidTokenException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, "ERRAUTH4010");
    }
}
