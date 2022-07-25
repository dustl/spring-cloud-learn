package com.learn.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ConfigServiceApplication.class);
        springApplication.setAdditionalProfiles("amqp");
        springApplication.run(args);
//        SpringApplication.run(ConfigServiceApplication.class, args);

    }

}
