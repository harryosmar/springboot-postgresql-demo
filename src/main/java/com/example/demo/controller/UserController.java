package com.example.demo.controller;

import com.example.demo.dto.ActivateUserRequestDTO;
import com.example.demo.dto.ActivateUserResponseDTO;
import com.example.demo.dto.CreateUserRequestDTO;
import com.example.demo.dto.CreateUserResponseDTO;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user",  produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/activate")
    public ResponseEntity<ActivateUserResponseDTO> activate(@RequestBody ActivateUserRequestDTO req) {
        return ResponseEntity.ok(this.userService.Activate(req));
    }

    @PostMapping("/register")
    public ResponseEntity<CreateUserResponseDTO> register(@RequestBody CreateUserRequestDTO userDTO) {
        return ResponseEntity.ok(userService.register(userDTO));
    }
}
