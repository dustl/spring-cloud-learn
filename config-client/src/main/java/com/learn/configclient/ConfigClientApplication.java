package com.learn.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ConfigClientApplication.class);
        springApplication.setAdditionalProfiles("amqp");
        springApplication.run(args);
//        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
