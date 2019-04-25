package com.jingtuo.controller;

import com.alibaba.fastjson.JSON;
import com.jingtuo.pojo.Book;
import com.jingtuo.service.IBookService;
import com.jingtuo.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Crested by 张鹏
 * Date 2018/12/26 8:58
 * version:1.0
 */
@Controller
@RequestMapping("/book")
public class BookController {

    /**
     * 跳转至分类页面
     *
     * @return
     */
    @RequestMapping("/toBookList")
    public String toBookList() {
        return "bookList";
    }

    /**
     * 查询分类下的所有书籍
     *
     * @param category
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findBooks", produces = "text/html;charset=UTF-8")
    public String findBooks(String category) {
        IBookService iBookService = new BookServiceImpl();
        List<Book> books = iBookService.findBooks(category);
        System.out.println(category);
        Map result = new HashMap();
        result.put("books", books);
        String booksJson = JSON.toJSONString(result);
        return booksJson;
    }
}
