package com.jingtuo.service;

import com.jingtuo.pojo.User;

import java.util.List;

/**
 * Crested by 张鹏
 * Date 2018/12/23 11:16
 * version:1.0
 */
public interface IUserService {

    /**
     * 添加用户
     * @param user
     */
    public void add(User user);

    /**
     * 查询所有用户
     * @return
     */
    public List findAll();
}
