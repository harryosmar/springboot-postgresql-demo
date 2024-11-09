package com.example.demo.dto;

public class TokenDTO {
    private String token;
    private long exp;

    public TokenDTO(String token, long exp) {
        this.token = token;
        this.exp = exp;
    }

    public String getToken() {
        return token;
    }

    public long getExp() {
        return exp;
    }
}
