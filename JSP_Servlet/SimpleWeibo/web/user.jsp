<%--
  Created by IntelliJ IDEA.
  User: xuanc
  Date: 19-3-4
  Time: 下午6:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="java.util.Date, java.text.SimpleDateFormat" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="zh-CN"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>用户中心 - ${requestScope.username}</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container" style="width: 100%; ">
    <div id="header" style="text-align: center; background-color: burlywood; padding: 5px">
        <h1>用户中心 - ${requestScope.username}</h1>
    </div>
    <c:choose>
        <c:when test="${requestScope.blahs != null}">
            <div id="userData" style="background-color: antiquewhite; height: 500px; width: 30%; float: left;">
                <br/>&emsp;<img src="../images/avatar.jpg" style="border-radius: 50%; width: 100px; height: 100px;"/>
                <span style="vertical-align: top"><b>用户： ${requestScope.username}</b></span><br/>
                    <%--&emsp;some...--%>
            </div>
            <div id="message" style="background-color: beige; width: 70%; float: left;">

                    <%--消息--%>

                <c:forEach var="blah" items="${requestScope.blahs}">
                    <%--使用<c:out>转义html字符--%>
                    <p><c:out value="${blah.escapeMessage}" /></p>
                    <%--需要处理特殊字符--%>
                    ${blah.username} - <fmt:formatDate value="${blah.date}" type="both" timeStyle="full" dateStyle="full"/>
                    <hr style="width: 70%;"/>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <div id="errorMsg" style="color: red; vertical-align: center;">
                <h2>用户${requestScope.username}不存在</h2>
            </div>
        </c:otherwise>
    </c:choose>

    <div id="footer" style="background-color: bisque; text-align:center;">
        版权 © SimpleWeibo
    </div>
</div>
<script>
    <%--控制用户信息部分的宽度，使其与微博显示的页面等宽--%>
    window.onload = function () {
        var o = document.getElementById("message");
        var h = o.clientHeight||o.offsetHeight;
        document.getElementById("userData").style.height = h + "px";
    }
</script>
</body>
</html>
