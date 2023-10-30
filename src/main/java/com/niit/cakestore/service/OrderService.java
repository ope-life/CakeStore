package com.niit.cakestore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.cakestore.common.Result;
import com.niit.cakestore.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService extends IService<Order> {
    Result<Order> pay( Long id);

}
