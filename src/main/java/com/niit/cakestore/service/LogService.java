package com.niit.cakestore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.cakestore.entity.Log;
import com.niit.cakestore.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface LogService extends IService<Log> {


    String getIpAddress();
    User getUser();
    void log(String content);

    void log(String username, String content);



}
