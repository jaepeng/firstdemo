package com.example.firstdemo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloSpringBoot {
    @RequestMapping("/helloworld")
    public String say() {
        System.out.println("WTF:Hello springboot");
        return "hello,this is a springboot demo";
    }

}
