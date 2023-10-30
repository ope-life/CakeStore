package com.niit.cakestore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.cakestore.entity.Permission;
import com.niit.cakestore.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionService extends IService<Permission> {
    void delete(Long id);

//    Object getByRoles(List<Role> roles);
    List<Permission> getByRoles(List<Role> roles);


}
