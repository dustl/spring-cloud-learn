package com.learn.feignservice.service;

import com.learn.feignservice.domain.CommonResult;
import com.learn.feignservice.domain.User;
import com.learn.feignservice.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:liwy
 * @date: 22.7.20
 * @Version:1.0
 */
@FeignClient(value = "user-service", fallback = UserFallbackService.class)
public interface UserService {

    @PostMapping("/user/create")
    CommonResult create(@RequestBody User user);

    /**
     * 注意！！
     * 要填写参数别名
     */
    @GetMapping("/user/{id}")
    CommonResult<User> getUser(@PathVariable("id") Long id);


    /**
     * 注意！！
     * 要填写参数别名
     */
    @GetMapping("/user/getByUsername")
    CommonResult<User> getByUsername(@RequestParam(value = "username") String username);

    @PostMapping("/user/update")
    CommonResult update(@RequestBody User user);

    /**
     * 注意！！
     * 要填写参数别名
     */
    @PostMapping("/user/delete/{id}")
    CommonResult delete(@PathVariable("id") Long id);


}
