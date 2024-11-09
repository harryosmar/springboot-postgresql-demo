package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class UserNotActiveException extends CustomException {
    public UserNotActiveException() {
        super("user not active", HttpStatus.UNAUTHORIZED, "ERR4013");
    }
}
