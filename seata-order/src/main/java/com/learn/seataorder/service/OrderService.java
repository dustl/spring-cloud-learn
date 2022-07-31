package com.learn.seataorder.service;


import com.learn.seataorder.domain.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
