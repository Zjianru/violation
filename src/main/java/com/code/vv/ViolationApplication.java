package com.code.vv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author Zjianru
 */
@MapperScan("com.code.vv.mapper")
@SpringBootApplication
public class ViolationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViolationApplication.class, args);
    }

}
