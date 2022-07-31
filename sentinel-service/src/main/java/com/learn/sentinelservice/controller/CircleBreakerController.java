package com.learn.sentinelservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.learn.sentinelservice.domain.CommonResult;
import com.learn.sentinelservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:liwy
 * @date: 22.7.28
 * @Version:1.0
 */
@RestController
@RequestMapping("/breaker")
public class CircleBreakerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;


    @RequestMapping("/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handleFallback")
    public CommonResult fallback(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{id}", CommonResult.class, id);
    }

    @RequestMapping("/fallbackException/{id}")
    @SentinelResource(value = "fallbackException", fallback = "handleFallback2", exceptionsToIgnore = {NullPointerException.class})
    public CommonResult fallbackException(@PathVariable Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    public CommonResult handleFallback(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser, "服务降级返回!!!", 200);
    }

    public CommonResult handleFallback2(@PathVariable Long id, Throwable e) {
        System.out.println("handleFallback2 id:{},throwable class:{}" + id + " " + e);
        User defaultUser = new User(-2L, "defaultUser2", "123456");
        return new CommonResult<>(defaultUser, "服务降级返回!!!", 200);
    }


}
