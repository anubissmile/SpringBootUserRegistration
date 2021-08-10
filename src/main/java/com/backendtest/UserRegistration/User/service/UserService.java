package com.backendtest.UserRegistration.User.service;

import com.backendtest.UserRegistration.User.entity.UserEntity;
import com.backendtest.UserRegistration.User.enumerate.MemberTypeEnum;
import com.backendtest.UserRegistration.User.model.create.request.CreateUserRequestModel;
import com.backendtest.UserRegistration.User.model.create.response.CreateUserResponseModel;
import com.backendtest.UserRegistration.User.model.create.response.data.CreateUserResponseDataModel;
import com.backendtest.UserRegistration.User.repository.UserRepository;
import com.backendtest.UserRegistration.shared.model.StatusModel;
import com.backendtest.UserRegistration.utils.PasswordUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public ResponseEntity<?> create(CreateUserRequestModel request) {
        UserEntity user = UserEntity.toModel(request);

        // Consider member type by salary.
        if (user.getSalary() < 15000) {
            // Return error msg.
            StatusModel status = new StatusModel("Cannot register bacause your salary is less than 15,000", 400);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(status);
        } else if (user.getSalary() < 30000) {
            user.setMemberType(MemberTypeEnum.SILVER);
        } else if (user.getSalary() <= 50000) {
            user.setMemberType(MemberTypeEnum.GOLD);
        } else {
            user.setMemberType(MemberTypeEnum.PLATINUM);
        }

        // Hashing password
        user.setPassword(PasswordUtils.hashPassword(request.getPassword()));

        // Build register code.
        String lastPhoneNo = StringUtils.right(user.getTelephone(), 4);
        String pattern = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        user.setRegistrationCode(String.format("%s%s", date, lastPhoneNo));

        // Store user.
        UserEntity userResult = repository.save(user);

        CreateUserResponseModel response = new CreateUserResponseModel(
                new StatusModel("Create user success!", 201),
                CreateUserResponseDataModel.toModel(userResult));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public UserEntity loadUserByUsername(String username) {
        Optional<UserEntity> userOptional = repository.findByUsername(username);
        if (!userOptional.isEmpty()) {
            return  userOptional.get();
        }
        return null;
    }
}
