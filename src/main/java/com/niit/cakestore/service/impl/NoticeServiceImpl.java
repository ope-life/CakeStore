package com.niit.cakestore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.cakestore.entity.Notice;
import com.niit.cakestore.mapper.NoticeMapper;
import com.niit.cakestore.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

}
