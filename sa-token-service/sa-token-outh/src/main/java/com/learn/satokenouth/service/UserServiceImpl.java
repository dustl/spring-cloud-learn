package com.learn.satokenouth.service;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import com.learn.satokencommon.domain.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:liwy
 * @date: 22.7.30
 * @Version:1.0
 */
@Service
@Slf4j
public class UserServiceImpl {

    private List<UserDTO> userDTOList;

    @PostConstruct
    public void init() {
        String passwrod = SaSecureUtil.md5("123123123");
        userDTOList = new ArrayList<>();
        userDTOList.add(UserDTO.builder()
                .id(1L)
                .password(passwrod)
                .username("li")
                .permissionList(CollUtil.toList("api:user:info", "api:test:hello")).build());
        userDTOList.add(UserDTO.builder()
                .id(2L)
                .username("admin")
                .password(SaSecureUtil.md5("123456"))
                .permissionList(CollUtil.toList("api:user:info"))
                .build());


    }

    public UserDTO loadUserByUserName(String userName) {
        List<UserDTO> collect = userDTOList.stream().filter(item -> item.getUsername().equals(userName)).collect(Collectors.toList());
        if (CollUtil.isEmpty(collect)) {
            return null;
        }
        return collect.get(0);
    }


    public SaTokenInfo login(String username,String password) {
        UserDTO userDTO = loadUserByUserName(username);
        log.info("userDto : {}",userDTO);
        if (userDTO == null) {
            return null;
        }
        if (!SaSecureUtil.md5(password).equals(userDTO.getPassword())) {
           return null;
        }
        StpUtil.login(userDTO.getId());
        StpUtil.getSession().set("userInfo", userDTO);
        SaTokenInfo saTokenInfo =StpUtil.getTokenInfo();

        return saTokenInfo;



    }


}
