package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class WrongLoginCredentialException extends CustomException {
    public WrongLoginCredentialException() {
        super("invalid login credential", HttpStatus.BAD_REQUEST, "ERRSIGN400");
    }
}
