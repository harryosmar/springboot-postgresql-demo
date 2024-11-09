package com.example.demo.dto;

public class UserWithRole {
    private String uid;
    private String role;

    public UserWithRole(String uid, String role) {
        this.uid = uid;
        this.role = role;
    }

    public String getUid() {
        return uid;
    }

    public String getRole() {
        return role;
    }
}
