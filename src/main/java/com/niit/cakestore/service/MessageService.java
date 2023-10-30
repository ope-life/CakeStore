package com.niit.cakestore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.cakestore.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService extends IService<Message> {
    List<Message> findByForeign(Long foreignId);


}
