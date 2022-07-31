package com.leran.satokengateway.config;

import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;

/**
 * @Author:liwy
 * @date: 22.7.30
 * @Version:1.0
 */
@Configuration
public class SaTokenConfig {


    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")
                .addExclude("/favicon.ico")
                .setAuth( r -> {
                    // 登陆认证
                    SaRouter.match("/**", "/outh/user/login", StpUtil::checkLogin);
                    // 权限认证，不同用户访问接口
                    SaRouter.match("/api/user/info", () -> StpUtil.checkPermission("api:user:info"));
                    SaRouter.match("/api/test/hello", () -> StpUtil.checkPermission("api:test:hello"));

                })
                .setError(e ->{
                    ServerWebExchange exchange = SaReactorSyncHolder.getContent();
                    exchange.getResponse().getHeaders().set("Content-Type", "application/json; charset=utf-8");
                    return SaResult.error(e.getMessage());
                });

    }

}
