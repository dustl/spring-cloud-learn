package com.learn.satokenouth.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.learn.satokencommon.api.CommonResult;
import com.learn.satokenouth.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取令牌
 * @Author:liwy
 * @date: 22.7.30
 * @Version:1.0
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public CommonResult login(@RequestParam(name = "username") String username,
                              @RequestParam(name = "password") String password) {
        log.info("请求 - - - - ");
        SaTokenInfo saTokenInfo = userService.login(username, password);
        if (saTokenInfo == null) {
            CommonResult.failed("用户名或密码错误");
        }
        Map<String,String>tokenMap = new HashMap<>();
        tokenMap.put("token", saTokenInfo.getTokenValue());
        tokenMap.put("tokenHead", saTokenInfo.getTokenName());
        return CommonResult.success(tokenMap);
    }

    @GetMapping("/get")
    public CommonResult get() {
        return CommonResult.success("mojap");
    }


}
