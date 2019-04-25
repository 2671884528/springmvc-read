package com.jingtuo.service;

import java.util.List;

/**
 * Crested by 张鹏
 * Date 2018/12/26 9:00
 * version:1.0
 */
public interface IBookService {

    /**
     * 查询分类下的所有书籍
     * @param category
     * @return
     */
    public List findBooks(String category);
}
