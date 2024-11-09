package com.example.demo.service;

import com.example.demo.dto.ActivateUserRequestDTO;
import com.example.demo.dto.ActivateUserResponseDTO;
import com.example.demo.dto.CreateUserRequestDTO;
import com.example.demo.dto.CreateUserResponseDTO;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.UsernameNotAvailableException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordUtils;

    public ActivateUserResponseDTO Activate(ActivateUserRequestDTO req) {
        Optional<User> existingOptUser = this.userRepository.findById(req.getId());
        if (existingOptUser.isEmpty()) {
            throw new UserNotFoundException();
        }

        User existingUser = existingOptUser.get();
        existingUser.setActive(true);
        User activatedUser = userRepository.save(existingUser);

        return new ActivateUserResponseDTO(activatedUser.getId(), activatedUser.isActive());
    }

    public CreateUserResponseDTO register(CreateUserRequestDTO req) {
        User existingUser = this.userRepository.findByUsername(req.getUsername());
        if (existingUser != null) {
            throw new UsernameNotAvailableException();
        }

        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(this.passwordUtils.encode(req.getPassword()));
        user.setRole(req.getRole());
        user.setIsDeleted(false);

        User newUser = userRepository.save(user);

        return new CreateUserResponseDTO(newUser.getId(), newUser.getUsername(), newUser.getRole());
    }
}
