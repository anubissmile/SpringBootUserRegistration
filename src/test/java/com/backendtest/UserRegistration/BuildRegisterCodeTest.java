package com.backendtest.UserRegistration;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BuildRegisterCodeTest {

    private String telephone = "0831601307";

    @Test
    public void test() {
        System.out.println(String.format("Phone : %s", StringUtils.right(telephone, 4)));
        String lastPhoneNo = StringUtils.right(telephone, 4);

        String pattern = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(String.format("Date : %s", date));
    }
}
