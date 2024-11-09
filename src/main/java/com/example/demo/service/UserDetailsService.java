package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService  {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userIdStr) throws UsernameNotFoundException {
        Integer userId = Integer.valueOf(userIdStr);
        Optional<User> userOpt = this.userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException("user not exist");
        }
        User user = userOpt.get();

        return org.springframework.security.core.userdetails.User.withUsername(userIdStr)
                .password("") // No password needed
                .authorities(user.getRole()) // Add your roles or authorities here
                .build();
    }
}
