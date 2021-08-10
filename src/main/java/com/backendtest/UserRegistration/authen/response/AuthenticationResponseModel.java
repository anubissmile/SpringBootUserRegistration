package com.backendtest.UserRegistration.authen.response;

import lombok.Data;

@Data
public class AuthenticationResponseModel {

    private String jwt;

    public AuthenticationResponseModel(String token) {
        setJwt(token);
    }

}
