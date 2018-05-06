package com.xuyueqi.service;

import com.xuyueqi.model.User;

import java.util.List;

/**
 * create by xuyueqi on 2018/5/5
 */
public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum,int pageSize);

}
