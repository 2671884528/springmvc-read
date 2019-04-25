package com.jingtuo.dao;

import com.jingtuo.pojo.User;
import com.jingtuo.utils.DBUtilsPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Crested by 张鹏
 * Date 2018/12/24 15:09
 * version:1.0
 */
public class UserDao {

    /**
     * 添加用户
     *
     * @param user
     */
    public static void add(User user) {

        //建立连接
        Connection connection = DBUtilsPool.getConnection();
        PreparedStatement preparedStatement = null;
        //创建sql
        String sql = "insert into test (user_name ,password) value (? ,?)";
        try {
            //预编译
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            DBUtilsPool.release(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有用户
     */
    public List<User> findAll() {

        //建立连接
        Connection connection = DBUtilsPool.getConnection();
        PreparedStatement preparedStatement = null;
        //创建sql
        String sql = "select * from test";
        //存放查询结果
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        try {
            //预编译
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUsername(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                list.add(user);
            }
            resultSet.close();
            preparedStatement.close();
            DBUtilsPool.release(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
