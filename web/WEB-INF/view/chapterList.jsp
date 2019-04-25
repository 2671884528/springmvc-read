<%--
  Created by IntelliJ IDEA.
  User: 小幸运
  Date: 2018/12/26
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>http://www.biqugecom.com/list/1-1.html</title>
    <link rel="stylesheet" type="text/css" href="/static/css/chapterList.css">
</head>
<body>

    <div class="book_con">
        <div class="image">
            <img src="/static/images/49400s.jpg">
        </div>
        <div class="book_con_right">
            <div class="book_name">
               <h1>
                   ${chapters.get(0).bookName}
               </h1>
            </div>
            <div class="book_author">
                作者： ${chapters.get(0).bookAuthor}
            </div>
        </div>
    </div>

    <div class="box_con">
        <dl>
            <dt><h1>目录</h1></dt>
            <c:forEach items="${chapters}" var="item">
                <dd><a href="/chapter/findContentById?bookId=${item.bookId}&chapterNum=${item.chapterNum}">${item.chapterName}</a></dd>
            </c:forEach>
        </dl>
    </div>

</body>
</html>
