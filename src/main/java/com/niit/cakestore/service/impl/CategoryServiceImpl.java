package com.niit.cakestore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.cakestore.entity.Category;
import com.niit.cakestore.mapper.CategoryMapper;
import com.niit.cakestore.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;
}
