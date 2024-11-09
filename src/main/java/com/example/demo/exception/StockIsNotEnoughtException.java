package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class StockIsNotEnoughtException extends CustomException {
    public StockIsNotEnoughtException() {
        super("stock is not enough", HttpStatus.BAD_REQUEST, "ERR4002");
    }
}
