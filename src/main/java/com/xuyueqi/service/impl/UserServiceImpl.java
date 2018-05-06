package com.xuyueqi.service.impl;

import com.xuyueqi.mapper.UserMapper;
import com.xuyueqi.model.User;
import com.xuyueqi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by xuyueqi on 2018/5/5
 */
@Slf4j
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        return userMapper.selectAllUser();
    }
}
