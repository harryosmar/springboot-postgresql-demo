package com.example.demo.dto;

public class ActivateUserResponseDTO {
    private Integer id;

    private Boolean isActive;

    public ActivateUserResponseDTO(Integer id, Boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getActive() {
        return isActive;
    }
}
