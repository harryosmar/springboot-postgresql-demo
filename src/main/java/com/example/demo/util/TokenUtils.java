package com.example.demo.util;

import com.example.demo.dto.TokenDTO;
import com.example.demo.dto.UserWithRole;
import com.example.demo.model.User;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface TokenUtils {
    TokenDTO generateToken(String username, String role);
    Claims validateToken(String token);
    UserWithRole getUserFromToken(String token);
}