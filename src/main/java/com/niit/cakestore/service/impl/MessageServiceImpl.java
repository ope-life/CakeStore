package com.niit.cakestore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.cakestore.entity.Message;
import com.niit.cakestore.entity.User;
import com.niit.cakestore.mapper.MessageMapper;
import com.niit.cakestore.service.MessageService;
import com.niit.cakestore.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>implements MessageService {
    @Resource
    private MessageMapper messageMapper;

    @Resource
    private UserService userService;

    public List<Message> findByForeign(Long foreignId) {
        LambdaQueryWrapper<Message> queryWrapper = Wrappers.<Message>lambdaQuery().eq(Message::getForeignId, foreignId).orderByDesc(Message::getId);
        List<Message> list = list(queryWrapper);
        for (Message Message : list) {
            User one = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, Message.getUsername()));
            Message.setAvatar("http://localhost:9999/files/" + one.getAvatar());
            Long parentId = Message.getParentId();
            list.stream().filter(c -> c.getId().equals(parentId)).findFirst().ifPresent(Message::setParentMessage);
        }
        return list;
    }
}
