package com.learn.sentinelservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.learn.sentinelservice.domain.CommonResult;
import com.learn.sentinelservice.handler.CustomBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:liwy
 * @date: 22.7.27
 * @Version:1.0
 */
@RestController
@RequestMapping("/ratelimiter")
public class RateLimiterController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResource() {
        return new CommonResult("按资源限流", 200);
    }



    /**
     * 按URL限流，有默认的限流处理逻辑
     */
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl",blockHandler = "handlerException")
    public CommonResult byUrl() {
        return new CommonResult("按url限流", 200);
    }


    /**
     * 自定义通用的限流处理逻辑
     */
    @GetMapping("/customBlockHandler")
    @SentinelResource(value = "customBlockHandler", blockHandler = "handlerException",blockHandlerClass = CustomBlockHandler.class)
    public CommonResult blockHandler() {
        return new CommonResult("限流成功", 200);
    }
    public CommonResult handlerException(BlockException exception){
        return new CommonResult("限流~~",200);
    }
}
