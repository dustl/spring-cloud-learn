package com.learn.satokenapi.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.learn.satokencommon.api.CommonResult;
import com.learn.satokencommon.domain.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取登录用户信息接口
 * Created by macro on 2020/6/19.
 */
@RestController
@RequestMapping("/user")
public class UserController{

    @GetMapping("/info")
    public CommonResult<UserDTO> userInfo() {
        UserDTO userDTO = (UserDTO) StpUtil.getSession().get("userInfo");
        return CommonResult.success(userDTO);
    }

}
