package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class InvalidRoleException extends CustomException {
    public InvalidRoleException() {
        super("Invalid JWT Role", HttpStatus.UNAUTHORIZED, "ERR4011");
    }
}
