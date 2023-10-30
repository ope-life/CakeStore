package com.niit.cakestore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.cakestore.entity.Cart;
import com.niit.cakestore.entity.Goods;
import com.niit.cakestore.entity.OrderGoods;
import com.niit.cakestore.mapper.OrderGoodsMapper;
import com.niit.cakestore.service.GoodsService;
import com.niit.cakestore.service.OrderGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class OrderGoodsServiceImpl extends ServiceImpl<OrderGoodsMapper,OrderGoods>implements OrderGoodsService {
    @Resource
    private OrderGoodsMapper orderGoodsMapper;
    @Resource
    private GoodsService goodsService;

    /**
     * 根据订单id查询订单关联的商品列表
     * @param orderId
     * @return
     */
    public List<Cart> findByOrderId(Long orderId) {
        List<Cart> carts = new ArrayList<>();
        List<OrderGoods> orderGoods = orderGoodsMapper.findGoodsByOrderId(orderId);
        for (OrderGoods orderGood : orderGoods) {
            Long goodsId = orderGood.getGoodsId();
            Goods goods = goodsService.getById(goodsId);
            Cart cart = new Cart();
            cart.setGoods(goods);
            cart.setGoodsId(goodsId);
            cart.setCount(orderGood.getCount());
            carts.add(cart);
        }
        return carts;
    }
}
