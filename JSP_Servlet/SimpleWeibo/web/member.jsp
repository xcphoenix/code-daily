<%--
  Created by IntelliJ IDEA.
  User: xuanc
  Date: 19-3-4
  Time: 下午6:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="zh-CN"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>个人主页 - ${sessionScope.login}</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <div id="header">
        <h1>个人中心 - ${sessionScope.login}</h1>
    </div>
    <div id="userData">
        <div class="avatar">
            <img src="images/avatar.jpg" alt="头像"/>
        </div>
        <div class="userMessage">
            <b>用户： ${sessionScope.login}</b><br/><br/>
            <b><a href="logout.do">注销</a></b>
        </div>
    </div>
    <div id="message">
        <%--输出存在的错误信息--%>
        <c:if test="${requestScope.error != null}">
            <div id="error" style="color: red">
                error: ${requestScope.error}<br/>
            </div>
        </c:if>

        <form action="message.do" method="get">
            <textarea name="message" value="" placeholder="发送一个微博～（234字以内）" autofocus cols="60"
                      rows="10">${requestScope.msg}</textarea>
            <br/><br/>
            <input type="submit" name="发布"/>
        </form>
        <br/>

        <%--消息--%>

        <c:if test="${requestScope.blahs != null}">
            <c:forEach var="blah" items="${requestScope.blahs}">
                <div class="weibo">
                    <p>${blah.escapeMessage}</p>

                    <span class="messageTime">
                        ${blah.username} - <fmt:formatDate value="${blah.date}" type="both" timeStyle="full"
                                                               dateStyle="full"/>
                        <a href=deleteMessage.do?date=${blah.date.time}>删除</a>
                    </span>
                </div>
            </c:forEach>
        </c:if>


    </div>
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
