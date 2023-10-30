package com.niit.cakestore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.cakestore.entity.Role;
import com.niit.cakestore.mapper.RoleMapper;
import com.niit.cakestore.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>implements RoleService {
    @Resource
    private RoleMapper roleMapper;

}
