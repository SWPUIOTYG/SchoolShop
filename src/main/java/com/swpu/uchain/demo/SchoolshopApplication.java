package com.swpu.uchain.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 禁止springboot自动注入数据源配置  @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = "com.swpu.uchain.demo.dao")
//@MapperScan("com.swpu.uchain.demo.dao")
public class SchoolshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolshopApplication.class, args);
    }

}
