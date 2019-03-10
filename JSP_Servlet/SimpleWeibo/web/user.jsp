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
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<div id="container">
    <div id="header">
        <h1>用户中心 - ${requestScope.username}</h1>
    </div>
    <c:choose>
        <c:when test="${requestScope.blahs != null}">
            <div id="userData">
                <div class="avatar">
                    <img src="../images/avatar.jpg" alt="头像"/>
                </div>
                <div class="userMessage">
                    <b>用户： ${requestScope.username}</b>
                </div>
            </div>
            <div id="message">
                    <%--消息--%>
                <c:forEach var="blah" items="${requestScope.blahs}">
                    <div class="weibo">
                        <p>${blah.escapeMessage}</p>

                        <span class="messageTime">
                        ${blah.username} - <fmt:formatDate value="${blah.date}" type="both" timeStyle="full"
                                                           dateStyle="full"/>
                        <c:if test="${sessionScope.login != null && requestScope.username eq sessionScope.login}">
                            <a href=deleteMessage.do?date=${blah.date.time}>删除</a>
                        </c:if>
                    </span>
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <div id="errorMsg" style="color: red; vertical-align: center;">
                <h2>用户${requestScope.username}不存在</h2>
            </div>
        </c:otherwise>
    </c:choose>

    <div id="footer">
        版权 © SimpleWeibo
    </div>
</div>
<script>
    <%--控制用户信息部分的宽度，使其与微博显示的页面等宽--%>
    window.onload = function () {
        e();
    };
    window.onresize = function () {
        e();
    };

    function e() {
        var o = document.getElementById("message");
        var h = o.clientHeight || o.offsetHeight;
        document.getElementById("userData").style.height = h + "px";

        var pageWeight = document.body.clientWidth;
        document.getElementById("message").style.width = pageWeight - 330 + "px";
    }
</script>
</body>
</html>
