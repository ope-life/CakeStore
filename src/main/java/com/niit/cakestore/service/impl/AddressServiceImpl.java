package com.niit.cakestore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.cakestore.entity.Address;
import com.niit.cakestore.mapper.AddressMapper;
import com.niit.cakestore.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
    @Resource
    private AddressMapper addressMapper;
}
