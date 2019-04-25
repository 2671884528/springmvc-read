<%--
  Created by IntelliJ IDEA.
  User: 小幸运
  Date: 2018/12/21
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <table border="1px">
        <thead>
            <tr>
                <td>用户名</td>
                <td>密码</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userList}" var="item">
                <tr>
                    <td>${item.username}</td>
                    <td>${item.password}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
