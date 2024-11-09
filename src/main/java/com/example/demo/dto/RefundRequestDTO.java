package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RefundRequestDTO {
    private String transactionId;

    @JsonCreator
    public RefundRequestDTO(@JsonProperty("transaction_id") String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return this.transactionId;
    }
}
