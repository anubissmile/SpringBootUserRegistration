package com.backendtest.UserRegistration.User.service;

import com.backendtest.UserRegistration.User.entity.UserEntity;
import com.backendtest.UserRegistration.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    private String password;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(username, password, new ArrayList<>());
    }

    public UserDetails loadUserByUsernameAndPassword(String username, String password) {
        UserEntity user = userService.loadUserByUsername(username);
        if (PasswordUtils.checkPassword(password, user.getPassword())) {
            this.password = password;
            return  loadUserByUsername(username);
        }
        return null;
    }
}
