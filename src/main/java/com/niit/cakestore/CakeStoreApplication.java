package com.niit.cakestore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.niit.cakestore.mapper")
@SpringBootApplication
public class CakeStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CakeStoreApplication.class, args);
    }
}
