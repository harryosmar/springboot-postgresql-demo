package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class TransactionNotFoundException extends CustomException {
    public TransactionNotFoundException() {
        super("transaction not found", HttpStatus.BAD_REQUEST, "ERR4041");
    }
}
