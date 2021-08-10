package com.backendtest.UserRegistration.User.service;

import com.backendtest.UserRegistration.User.entity.UserEntity;
import com.backendtest.UserRegistration.User.model.create.request.CreateUserRequestModel;
import com.backendtest.UserRegistration.User.model.create.response.CreateUserResponseModel;
import com.backendtest.UserRegistration.User.repository.UserRepository;
import com.backendtest.UserRegistration.shared.model.StatusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public ResponseEntity<?> create(CreateUserRequestModel request) {
        UserEntity user = UserEntity.toModel(request);
        repository.save(user);
        CreateUserResponseModel response = new CreateUserResponseModel(
                new StatusModel("Create user success!", 201), request);
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
