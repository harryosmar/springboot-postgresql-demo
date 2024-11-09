package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseRequestDTO {
    private Integer qty;
    private Integer productId;

    @JsonCreator
    public PurchaseRequestDTO(@JsonProperty("qty") Integer qty, @JsonProperty("product_id") Integer productId) {
        this.qty = qty;
        this.productId = productId;
    }

    public Integer getQty() {
        return qty;
    }

    public Integer getProductId() {
        return productId;
    }
}
