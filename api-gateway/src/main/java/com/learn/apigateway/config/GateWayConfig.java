package com.learn.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:liwy
 * @date: 22.7.25
 * @Version:1.0
 */
@Configuration
public class GateWayConfig {


//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes().route(
//                "path_route2",r->
//                    r.path("/user/getByName")
//                            .uri("http://127.0.0.1:8882/user/getByUserName")
//        ).build();
//    }

}
