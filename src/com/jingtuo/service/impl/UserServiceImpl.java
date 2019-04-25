package com.jingtuo.service.impl;

import com.jingtuo.dao.UserDao;
import com.jingtuo.pojo.User;
import com.jingtuo.service.IUserService;

import java.util.List;

/**
 * Crested by 张鹏
 * Date 2018/12/24 11:41
 * version:1.0
 */
public class UserServiceImpl implements IUserService {

    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao = new UserDao();
        userDao.add(user);
    }

    @Override
    public List findAll() {
        userDao = new UserDao();
        return userDao.findAll();
    }
}
