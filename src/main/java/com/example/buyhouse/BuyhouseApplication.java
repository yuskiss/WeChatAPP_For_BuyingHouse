package com.example.buyhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.buyhouse.dao")
public class BuyhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyhouseApplication.class, args);
    }

}
