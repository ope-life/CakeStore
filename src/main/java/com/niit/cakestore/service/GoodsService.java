package com.niit.cakestore.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.cakestore.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService extends IService<Goods> {

    List<Goods> findAll();
    List<Goods> recommend();
    List<Goods> sales();
    IPage<Goods> pageByCategory(Page<Goods> page,Long id);
    IPage<Goods> findPage(Page<Goods> page,String name);

}
