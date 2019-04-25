<%--
  Created by IntelliJ IDEA.
  User: 小幸运
  Date: 2018/12/20
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加</title>
</head>
<body>
    <form action="/user/add.do" class="userRegister">
        username:<input type="text" id="username" name="username"><br>
        password:<input type="password" id="password" name="password"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
