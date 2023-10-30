package com.niit.cakestore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.cakestore.entity.Banner;
import com.niit.cakestore.mapper.BannerMapper;
import com.niit.cakestore.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {
    @Resource
    private BannerMapper bannerMapper;
}
