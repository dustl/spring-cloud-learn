package com.learn.seataorder.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:liwy
 * @date: 22.7.30
 * @Version:1.0
 */
@Configuration
@MapperScan(value = {"com.learn.seataorder.dao.**"})
public class MybatisPlusConfig {
}
