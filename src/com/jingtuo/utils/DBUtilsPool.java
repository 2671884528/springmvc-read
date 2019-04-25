package com.jingtuo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class DBUtilsPool {

    // 最大连接数
    private static final int COUNT = 3;
    // 存放数据库连接
    private static final LinkedList<Connection> connections = new LinkedList<>();
    // 创建锁
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();
    private static final Condition notFull = lock.newCondition();

    /**
     * 数据源连接信息
     */
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/books?characterEncoding=utf8&serverTimezone=GMT%2B8";
    private static String username = "root";
    private static String password = "root";

    static {
        try {
            //加载驱动
            Class.forName(driverName);
            Connection connection = null;
            for (int i = 0; i < COUNT; i++) {
                connection = DriverManager.getConnection(jdbcUrl, username, password);
                connections.add(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        final ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            //如果没有连接了，则等待着新放入的连接
            if (connections.isEmpty()) {
                notEmpty.await();
            }
            Connection connection = connections.removeFirst();
            notFull.signalAll();
            return connection;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return null;
    }

    /**
     * 释放连接
     *
     * @param connection
     */
    public static void release(Connection connection) {
        final ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (connections.size() == COUNT) {
                notFull.await();
            }
            if (connection == null || connection.isClosed()) {
                connections.add(DriverManager.getConnection(jdbcUrl, username, password));
                notEmpty.signalAll();
                return;
            }
            //恢复默认值
            if (connection.getAutoCommit() == false) {
                connection.setAutoCommit(true);
            }
            connections.add(connection);
            notEmpty.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

}
