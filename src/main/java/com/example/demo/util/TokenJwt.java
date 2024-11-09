package com.example.demo.util;

import com.example.demo.dto.TokenDTO;
import com.example.demo.dto.UserWithRole;
import com.example.demo.exception.InvalidRoleException;
import com.example.demo.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

public class TokenJwt implements TokenUtils {
    private String secretKey;
    private long expTime;  // in milliseconds

    private SignatureAlgorithm alg;

    public TokenJwt(String secretKey, long expTime, SignatureAlgorithm alg) {
        this.secretKey = secretKey;
        this.expTime = expTime;
        this.alg = alg;
    }

    @Override
    public TokenDTO generateToken(String username, String role) {
        Map<String, Object> customClaims = new HashMap<>();
        customClaims.put("role", role);

        Date expiration = new Date(System.currentTimeMillis() + this.expTime);
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiration)
                .signWith(this.alg, this.secretKey)
                .setId(UUID.randomUUID().toString())
                .addClaims(customClaims)
                .compact();

        return new TokenDTO(token, expiration.getTime() / 1000);
    }

    @Override
    public Claims validateToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(this.secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new InvalidTokenException(e.getMessage());
        }
    }

    @Override
    public UserWithRole getUserFromToken(String token) {
        Claims claim = this.validateToken(token);
        Object role = claim.getOrDefault("role", "");
        String roleStr = (String) role;
        if (role == "") {
            throw new InvalidRoleException();
        }
        return new UserWithRole(claim.getSubject(), roleStr);
    }
}
