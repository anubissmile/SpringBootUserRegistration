package com.backendtest.UserRegistration.User.model.create.response;

import com.backendtest.UserRegistration.User.enumerate.MemberTypeEnum;
import com.backendtest.UserRegistration.User.model.create.request.CreateUserRequestModel;
import com.backendtest.UserRegistration.User.model.create.response.data.CreateUserResponseDataModel;
import com.backendtest.UserRegistration.shared.model.StatusModel;
import lombok.Data;

@Data
public class CreateUserResponseModel {

    private StatusModel status;

    private CreateUserResponseDataModel data;

    public CreateUserResponseModel(StatusModel status, CreateUserResponseDataModel data) {
        this.status = status;
        this.data = data;
    }
}
