package com.learn.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ApiGatewayApplication.class);
        springApplication.setAdditionalProfiles("filter");
        springApplication.run(args);
//        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
