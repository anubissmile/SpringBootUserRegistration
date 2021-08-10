package com.backendtest.UserRegistration;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordEncodeTest {

    @Test
    public void test() {
        String salt = BCrypt.gensalt();
        String hash = BCrypt.hashpw("1234", salt);
        System.out.println(String.format("Hash : %s", hash));
    }
}
