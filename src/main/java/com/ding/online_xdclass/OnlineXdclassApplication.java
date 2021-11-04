package com.ding.online_xdclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.ding.online_xdclass.mapper")

public class OnlineXdclassApplication {

    public static void main(String[] args) {

        SpringApplication.run(OnlineXdclassApplication.class, args);

    }

}
