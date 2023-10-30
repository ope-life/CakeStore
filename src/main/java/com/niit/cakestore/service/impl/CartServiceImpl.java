package com.niit.cakestore.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.cakestore.entity.Cart;
import com.niit.cakestore.entity.Goods;
import com.niit.cakestore.mapper.CartMapper;
import com.niit.cakestore.service.CartService;
import com.niit.cakestore.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>implements CartService {
    @Resource
    private GoodsService goodsService;

    /**
     * 计算购物车商品总价和优惠金额
     * @param carts
     * @return
     */
    public Map<String, Object> findAll(List<Cart> carts) {
        BigDecimal totalPrice = new BigDecimal(0);
        BigDecimal originPrice = new BigDecimal(0);
        Map<String, Object> res = new HashMap<>();
        if (CollUtil.isEmpty(carts)) {
            carts = list();
        }

        for (Cart cart : carts) {
            Long goodsId = cart.getGoodsId();
            Goods goods = goodsService.getById(goodsId);
            goods.setRealPrice(goods.getPrice().multiply(BigDecimal.valueOf(goods.getDiscount())));
            cart.setGoods(goods);

            totalPrice = totalPrice.add(goods.getRealPrice().multiply(BigDecimal.valueOf(cart.getCount())));
            originPrice = originPrice.add(goods.getPrice().multiply(BigDecimal.valueOf(cart.getCount())));
        }

        res.put("list", carts);  // 购物车列表
        res.put("totalPrice", totalPrice);  // 总价
        res.put("discount", originPrice.subtract(totalPrice));    // 折扣优惠金额
        return res;
    }
}
