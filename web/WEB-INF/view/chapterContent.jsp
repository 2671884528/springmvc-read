<%--
  Created by IntelliJ IDEA.
  User: 小幸运
  Date: 2018/12/27
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>http://www.biqugecom.com/list/1-1.html</title>
    <link type="text/css" rel="stylesheet" href="/static/css/chapterContent.css">
    <script type="text/javascript" src="/static/js/jquery-3.3.1.js"></script>
</head>
<body>
    <div class="box_con">
        <div class="chapter_name">
            <h1>${chapter.chapterName}</h1>
            <div class="top">
                <a href="/chapter/findContentById?bookId=${chapter.bookId}&chapterNum=${chapter.lastChapterNum}">上一章</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/chapter/findContentById?bookId=${chapter.bookId}&chapterNum=${chapter.nextChapterNum}">下一章</a>
            </div>
        </div>
        <div class="content">
            ${chapter.chapterContent}
        </div>
        <div class="bottom">
            <a href="/chapter/findContentById?bookId=${chapter.bookId}&chapterNum=${chapter.lastChapterNum}">上一章</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/chapter/toChapterList?bookId=${chapter.bookId}">目录</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/chapter/findContentById?bookId=${chapter.bookId}&chapterNum=${chapter.nextChapterNum}">下一章</a>
        </div>
    </div>
</body>
</html>
