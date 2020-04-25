package com.learn.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.learn"})
public class LearnWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnWebApplication.class);
    }
}
