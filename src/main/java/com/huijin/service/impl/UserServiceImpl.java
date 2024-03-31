package com.huijin.service.impl;

import com.huijin.mapper.UserMapper;
import com.huijin.model.User;
import com.huijin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getUserList() {
        return userMapper.getAllUser();
    }

    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Override
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        userMapper.save(user);
    }

    @Override
    public void edit(User user) {
        userMapper.edit(user);
    }

    @Override
    public void delete(String id) {
        userMapper.delete(id);
    }
}
