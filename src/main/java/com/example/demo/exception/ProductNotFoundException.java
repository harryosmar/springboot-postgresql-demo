package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends CustomException {
    public ProductNotFoundException() {
        super("product not found", HttpStatus.BAD_REQUEST, "ERR4042");
    }
}
