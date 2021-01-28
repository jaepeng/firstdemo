package com.example.firstdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


//
@SpringBootApplication(scanBasePackages={"com.example.firstdemo"})
//@ServletComponentScan
public class FirstdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstdemoApplication.class, args);
    }

}
