package com.learn.apigateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * @Author:liwy
 * @date: 22.7.26
 * @Version:1.0
 * 1：根据username进行限流
 * 2：根据访问ip进行限流
 */
@Configuration
public class RequestRateLimiter {

    @Bean
    public KeyResolver userResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("username"));
    }

    @Bean
    @Primary
    public KeyResolver ipResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }





}
