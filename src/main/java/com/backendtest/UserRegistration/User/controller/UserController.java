package com.backendtest.UserRegistration.User.controller;

import com.backendtest.UserRegistration.User.entity.UserEntity;
import com.backendtest.UserRegistration.User.model.create.request.CreateUserRequestModel;
import com.backendtest.UserRegistration.User.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok(new CreateUserRequestModel());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CreateUserRequestModel request) {
        return userService.create(request);
    }
}
