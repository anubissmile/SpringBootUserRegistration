package com.backendtest.UserRegistration.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtils {

    public static String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        String hash = BCrypt.hashpw(password, salt);
        return  hash;
    }

    public static boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
