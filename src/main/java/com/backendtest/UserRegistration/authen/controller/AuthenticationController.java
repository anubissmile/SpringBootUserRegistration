package com.backendtest.UserRegistration.authen.controller;

import com.backendtest.UserRegistration.User.service.MyUserDetailService;
import com.backendtest.UserRegistration.authen.request.AuthenticationRequestModel;
import com.backendtest.UserRegistration.authen.response.AuthenticationResponseModel;
import com.backendtest.UserRegistration.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialException;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService userDetailService;

    private JwtTokenUtils jwtTokenUtils = new JwtTokenUtils();

    @PostMapping
    public ResponseEntity<AuthenticationResponseModel> authentication(@RequestBody AuthenticationRequestModel request) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final UserDetails userDetails = userDetailService.loadUserByUsername(request.getUsername());
        final String jwt = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponseModel(jwt));
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return ResponseEntity.ok("Log out success");
    }
}
