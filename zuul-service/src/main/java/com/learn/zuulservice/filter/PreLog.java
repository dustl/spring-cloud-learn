package com.learn.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:liwy
 * @date: 22.7.24
 * @Version:1.0
 */
@Component
@Slf4j
public class PreLog extends ZuulFilter {


    /**
     * 过滤器类型 ：  pre routing post error
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否进行过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 执行内容，shouldFilter为true执行
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String remoteUser = request.getRemoteUser();
        String remoteHost = request.getRemoteHost();
        String requestURI = request.getRequestURI();
        String method = request.getMethod();

        log.info("user:{},host:{}, uri:{},method:{} ", remoteUser, remoteHost, requestURI, method);

        return null;
    }
}
