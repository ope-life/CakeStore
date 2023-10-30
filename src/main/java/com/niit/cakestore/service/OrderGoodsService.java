package com.niit.cakestore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.cakestore.entity.Cart;
import com.niit.cakestore.entity.OrderGoods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderGoodsService extends IService<OrderGoods> {
    List<Cart> findByOrderId(Long orderId);


}
