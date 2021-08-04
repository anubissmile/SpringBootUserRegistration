package com.backendtest.UserRegistration.User.service;

import com.backendtest.UserRegistration.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

}
