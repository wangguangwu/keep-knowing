package com.wangguangwu.keepknowing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangguangwu
 */
@SpringBootApplication
@MapperScan("com.wangguangwu.keepknowing.mapper")
public class KeepKnowingApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeepKnowingApplication.class, args);
    }

}
