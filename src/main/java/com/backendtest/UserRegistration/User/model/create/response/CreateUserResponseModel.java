package com.backendtest.UserRegistration.User.model.create.response;

import com.backendtest.UserRegistration.User.enumerate.MemberTypeEnum;
import com.backendtest.UserRegistration.User.model.create.request.CreateUserRequestModel;
import com.backendtest.UserRegistration.shared.model.StatusModel;
import lombok.Data;

@Data
public class CreateUserResponseModel {

    private StatusModel status;

    private CreateUserRequestModel data;

    public CreateUserResponseModel(StatusModel status, CreateUserRequestModel data) {
        this.status = status;
        this.data = data;
    }
}
