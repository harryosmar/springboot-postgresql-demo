package com.example.demo.service;

import com.example.demo.dto.CreateUserRequestDTO;
import com.example.demo.dto.CreateUserResponseDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.TokenDTO;
import com.example.demo.exception.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordUtils;

    @Autowired
    private TokenUtils tokenUtils;

    public TokenDTO login(LoginDTO req) throws CustomException {
        User userRecord = userRepository.findByUsername(req.getUsername());
        if (userRecord == null) {
            throw new UserNotFoundException();
        }

        if (!userRecord.isActive()) {
            throw new UserNotActiveException();
        }

        if (!this.passwordUtils.matches(req.getPassword(), userRecord.getPassword())) {
            throw new WrongLoginCredentialException();
        }

        return this.tokenUtils.generateToken(String.valueOf(userRecord.getId()), userRecord.getRole());
    }
}
