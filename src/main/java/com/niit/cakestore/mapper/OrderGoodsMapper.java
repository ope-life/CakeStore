package com.niit.cakestore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niit.cakestore.entity.OrderGoods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderGoodsMapper extends BaseMapper<OrderGoods> {

    @Select("select * from order_goods where order_id = #{orderId}")
    List<OrderGoods> findGoodsByOrderId(@Param("orderId") Long orderId);
}
