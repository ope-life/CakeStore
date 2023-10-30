package com.niit.cakestore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.cakestore.entity.Permission;
import com.niit.cakestore.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends IService<User> {


    User login(User user);

    User register(User user);

    List<Permission> getPermissions(Long userId);
    User getByUsername(String username);
    User findById(Long id);

}
