package com.code.vv;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class ViolationApplicationTests {

    @Test
    void DateTest() {
        Date maxTime = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(maxTime);
        cal.add(Calendar.YEAR, -1);
        cal.add(Calendar.DATE,1);
        Date minTime = cal.getTime();
        System.out.println(maxTime);
        System.out.println(minTime);
    }



}
