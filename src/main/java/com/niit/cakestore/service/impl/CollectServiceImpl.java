package com.niit.cakestore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.cakestore.entity.Collect;
import com.niit.cakestore.mapper.CollectMapper;
import com.niit.cakestore.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect>implements CollectService {
    @Resource
    private CollectMapper collectMapper;
}
