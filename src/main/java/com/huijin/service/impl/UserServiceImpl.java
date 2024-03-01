package com.huijin.service.impl;

import com.huijin.model.User;
import com.huijin.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUserList() {
        List<User> result = new ArrayList<>();
        User u1 = new User();
        u1.setId(1);
        u1.setAge(18);
        u1.setUserName("张三");
        u1.setPassword("1234");
        result.add(u1);

        User u2 = new User();
        u2.setId(2);
        u2.setAge(20);
        u2.setUserName("李四");
        u2.setPassword("12345");
        result.add(u2);

        User u3 = new User();
        u3.setId(3);
        u3.setAge(40);
        u3.setUserName("王五");
        u3.setPassword("123456");
        result.add(u3);

        return result;
    }

    @Override
    public User findUserById(long id) {
        User u1 = new User();
        u1.setId(1);
        u1.setAge(18);
        u1.setUserName("张三");
        u1.setPassword("1234");
        return u1;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(long id) {

    }
}
