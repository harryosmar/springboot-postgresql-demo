package com.example.demo.exception;

import com.example.demo.dto.ErrorResponse;
import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private HttpStatus statusCode;
    private ErrorResponse errorResponse;
    public CustomException(String message, HttpStatus statusCode, String errorCode) {
        super(message);
        this.statusCode = statusCode;
        this.errorResponse = new ErrorResponse(message, errorCode);
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public HttpStatus getStatusCode() {
        return this.statusCode;
    }
}
