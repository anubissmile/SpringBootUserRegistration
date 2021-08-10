package com.backendtest.UserRegistration.User.controller;

import com.backendtest.UserRegistration.User.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<?> hello() {
        String hash = BCrypt.hashpw("THIS IS PASSWORD", BCrypt.gensalt(12));
        System.out.println("Say hello" + hash);
        String res = String.format("Hey friends", " : ", hash);
        return ResponseEntity.ok(res.toString());
    }
}
