package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RefundResponseDTO {
    private String transactionId;
    private boolean isVoid;

    @JsonCreator
    public RefundResponseDTO(@JsonProperty("transaction_id") String transactionId, @JsonProperty("is_void") boolean isVoid) {
        this.transactionId = transactionId;
        this.isVoid = isVoid;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public boolean isVoid() {
        return isVoid;
    }
}
