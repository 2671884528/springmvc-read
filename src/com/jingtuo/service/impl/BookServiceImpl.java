package com.jingtuo.service.impl;

import com.jingtuo.dao.BookDao;
import com.jingtuo.service.IBookService;

import java.util.List;

/**
 * Crested by 张鹏
 * Date 2018/12/26 9:02
 * version:1.0
 */
public class BookServiceImpl implements IBookService {

    /**
     * 查询分类下的所有书籍
     * @param category
     * @return
     */
    @Override
    public List findBooks(String category) {
        BookDao bookDao = new BookDao();
        return bookDao.findBooks(category);
    }
}
