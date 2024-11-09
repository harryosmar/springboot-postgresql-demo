package com.example.demo.security;

import com.example.demo.util.TokenJwt;
import com.example.demo.util.TokenUtils;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {

    @Value("${app.token.secret}")
    private String secretKey;

    @Value("${app.token.ttl}")
    private long ttl;

    @Bean
    public TokenUtils tokenUtils() {
        return new TokenJwt(this.secretKey, this.ttl, SignatureAlgorithm.HS512);
    }
}
