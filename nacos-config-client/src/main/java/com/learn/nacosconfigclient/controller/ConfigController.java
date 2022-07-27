package com.learn.nacosconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:liwy
 * @date: 22.7.27
 * @Version:1.0
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/getConfigInfo")
    public String getConfigInfo() {
        return configInfo;
    }







}
