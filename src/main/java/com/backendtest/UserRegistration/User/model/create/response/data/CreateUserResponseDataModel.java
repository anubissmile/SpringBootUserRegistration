package com.backendtest.UserRegistration.User.model.create.response.data;

import com.backendtest.UserRegistration.User.entity.UserEntity;
import com.backendtest.UserRegistration.User.enumerate.MemberTypeEnum;
import lombok.Data;

import java.util.Date;

@Data
public class CreateUserResponseDataModel {

    private String username;

    private String telephone;

    private String address;

    private Double salary;

    private MemberTypeEnum memberType;

    private String registrationCode;

    private Date createdAt;

    private Date updateAt;

    public CreateUserResponseDataModel(String username, String telephone, String address, Double salary, MemberTypeEnum memberType, String registrationCode, Date createdAt, Date updateAt) {
        this.username = username;
        this.telephone = telephone;
        this.address = address;
        this.salary = salary;
        this.memberType = memberType;
        this.registrationCode = registrationCode;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public static CreateUserResponseDataModel toModel(UserEntity user) {
        return new CreateUserResponseDataModel(
                user.getUsername(),
                user.getTelephone(),
                user.getAddress(),
                user.getSalary(),
                user.getMemberType(),
                user.getRegistrationCode(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
    }
}
