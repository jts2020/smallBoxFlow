package com.jts.small.flow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class SmallFlowMain {

    public static void main(String[] args) {
        SpringApplication.run(SmallFlowMain.class, args);
    }
}
