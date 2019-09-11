package com.swpu.uchain.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.swpu.uchain.demo.dao")
public class SchoolshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolshopApplication.class, args);
    }

}
