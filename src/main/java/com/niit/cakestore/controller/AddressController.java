package com.niit.cakestore.controller;

import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niit.cakestore.common.Result;
import com.niit.cakestore.entity.Address;
import com.niit.cakestore.entity.User;
import com.niit.cakestore.service.AddressService;
import com.niit.cakestore.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    // 将HttpServletRequest实例注入到控制器类中，用于获取HTTP请求的信息。
    @Resource
    private HttpServletRequest request;
    @Resource
    private UserService userService;

    // 定义一个方法，用于获取当前用户的信息。它从HTTP请求头中获取token，然后解码token获取用户名，最后通过用户名查询用户信息。
    public User getUser() {
        String token = request.getHeader("token");
        String username = JWT.decode(token).getAudience().get(0);
        return userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
    }

    // 使用@PostMapping注解指定POST请求的映射路径，并定义一个方法用于保存一个地址。它将地址对象保存到数据库中并返回成功结果。
    @PostMapping
    public Result<?> save(@RequestBody Address address) {
        addressService.save(address);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Address address) {
        addressService.updateById(address);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        addressService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> findById(@PathVariable Long id) {
        return Result.success(addressService.getById(id));
    }

    @GetMapping
    public Result<?> findAll() {
        LambdaQueryWrapper<Address> query = Wrappers.<Address>lambdaQuery().orderByDesc(Address::getId);
        query.eq(Address::getUserId, getUser().getId());
        List<Address> list = addressService.list(query);
        return Result.success(list);
    }

    @GetMapping("/page")
    public Result<?> findPage(
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<Address> query = Wrappers.<Address>lambdaQuery().orderByDesc(Address::getId);
//        query.eq(Address::getUserId, getUser().getId());
        IPage<Address> page = addressService.page(new Page<>(pageNum, pageSize), query);
        return Result.success(page);
    }

}
