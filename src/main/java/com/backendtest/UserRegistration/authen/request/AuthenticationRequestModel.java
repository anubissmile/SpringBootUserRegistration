package com.backendtest.UserRegistration.authen.request;

import lombok.Data;

@Data
public class AuthenticationRequestModel {

    private String username;

    private String password;

    public AuthenticationRequestModel(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

}
