package com.jingtuo.dao;

import com.jingtuo.pojo.Book;
import com.jingtuo.utils.DBUtilsPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Crested by 张鹏
 * Date 2018/12/26 8:59
 * version:1.0
 */
public class BookDao {

    /**
     * 查询分类下的所有书籍
     * @param category
     * @return
     */
    public List findBooks(String category){
        //从数据库连接池获取连接
        Connection connection = DBUtilsPool.getConnection();
        //创建sql
        String sql = "SELECT id ,book_name ,author FROM books WHERE category = '" +category+ "'";
        //用于存放查询结果
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            //预编译
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setCategory(category);
                book.setBookId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("author"));
                books.add(book);
            }
            resultSet.close();
            preparedStatement.close();
            //将数据库连接放回连接池
            DBUtilsPool.release(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
