package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivateUserRequestDTO {
    private Integer id;

    @JsonCreator
    public ActivateUserRequestDTO(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
}
