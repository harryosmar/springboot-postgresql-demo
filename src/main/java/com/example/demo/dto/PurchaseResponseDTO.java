package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseResponseDTO {
    private String transactionId;

    @JsonCreator
    public PurchaseResponseDTO(@JsonProperty("transaction_id") String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
