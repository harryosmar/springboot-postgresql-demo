package com.example.demo.dto;

public class CreateUserRequestDTO {
    private String username;
    private String password;
    private String role;

    public CreateUserRequestDTO(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
