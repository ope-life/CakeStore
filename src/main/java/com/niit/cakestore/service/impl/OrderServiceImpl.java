package com.niit.cakestore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.cakestore.common.Result;
import com.niit.cakestore.entity.Order;
import com.niit.cakestore.mapper.OrderMapper;
import com.niit.cakestore.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Result<Order> pay(Long id) {
        return null;
    }
}
