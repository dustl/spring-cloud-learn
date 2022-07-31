package com.learn.sentinelservice.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.learn.sentinelservice.domain.CommonResult;


/**
 *
 */
public class CustomBlockHandler {

    /**
     * 【自定义限流处理逻辑】中，
     * 指定 blockHandlerClass
     * 为对应的类的 Class 对象，
     * 注意对应的函数必需为 static 函数，否则无法解析，会报错。
     */
    public static CommonResult handler2Exception(BlockException exception) {
        return new CommonResult("自定义限流信息!!!!", 200);
    }
}
