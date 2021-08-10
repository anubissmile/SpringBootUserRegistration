package com.backendtest.UserRegistration.shared.model;

import lombok.Data;

@Data
public class StatusModel {

    private String message;

    private Integer status;

    public StatusModel(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}
