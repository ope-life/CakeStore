package com.niit.cakestore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.cakestore.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CartService extends IService<Cart> {

    Map<String, Object> findAll(List<Cart> carts);

}
