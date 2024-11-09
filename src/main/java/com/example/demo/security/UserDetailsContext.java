package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsContext {
    // Private constructor to prevent instantiation
    private UserDetailsContext() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String getUserIdFromContext() {
        // Assuming user info is retrieved from a context or security principal
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();
            } else {
                // In case of a different authentication mechanism
                return principal.toString();
            }
        }

        return "";
    }
}
