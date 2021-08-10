package com.backendtest.UserRegistration.User.model.create.request;

import com.backendtest.UserRegistration.User.enumerate.MemberTypeEnum;
import lombok.Data;

@Data
public class CreateUserRequestModel {

    private String username;

    private String telephone;

    private String address;

    private Double salary;

    private String password;

}
