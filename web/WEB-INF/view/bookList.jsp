<%--
  Created by IntelliJ IDEA.
  User: 小幸运
  Date: 2018/12/26
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>分类</title>
    <link rel="stylesheet" type="text/css" href="/static/css/bookListStyle.css">
    <script type="text/javascript" src="/static/js/jquery-3.3.1.js"></script>
</head>
<body>
    <nav class="nav">
        <ul>
            <li onclick="findCategoryBooks(this)">玄幻</li>
            <li onclick="findCategoryBooks(this)">仙侠</li>
            <li onclick="findCategoryBooks(this)">言情</li>
            <li onclick="findCategoryBooks(this)">历史</li>
            <li onclick="findCategoryBooks(this)">网游</li>
            <li onclick="findCategoryBooks(this)">科幻</li>
            <li onclick="findCategoryBooks(this)">恐怖</li>
            <li onclick="findCategoryBooks(this)">其他</li>
        </ul>
    </nav>
    <div class="books" id="books">
    </div>
    <footer class="footer">
        <p>版权所有，伪版必究</p>
    </footer>
    <script type="text/javascript" src="/static/js/bookList.js"></script>
</body>
</html>
