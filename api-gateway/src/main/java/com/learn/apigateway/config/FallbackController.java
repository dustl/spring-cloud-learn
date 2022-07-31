package com.learn.apigateway.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:liwy
 * @date: 22.7.25
 * @Version:1.0
 */

@RestController
public class FallbackController {


    @GetMapping("/fallback")
    public Object fallback() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", null);
        result.put("message", "Get request fallback!");
        result.put("code", 500);
        return result;
    }


}
