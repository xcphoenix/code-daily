<%--
  Created by IntelliJ IDEA.
  User: xuanc
  Date: 19-3-4
  Time: 下午6:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>个人主页 - ${sessionScope.login}</title>
</head>
<body>
<div id="container" style="width: 100%; margin-top: 0;">
    <div id="header" style="text-align: center; background-color: burlywood; margin-top: fill">
        <h1>个人中心 - ${sessionScope.login}</h1>
    </div>
    <div id="userData" style="background-color: antiquewhite; height: 500px; width: 30%; float: left;">
        <br/>&emsp;<img src="images/avatar.jpg" style="border-radius: 50%; width: 100px; height: 100px;"/>
        <span style="vertical-align: top"><b>用户： ${sessionScope.login}</b></span><br/>
        &emsp;some...
    </div>
    <div id="message" style="background-color: beige; width: 70%; float: left;">
        <%--输出存在的错误信息--%>
        <c:if test="${requestScope.error != null}">
            <div id="error" style="color: red">
                error: ${requestScope.error}<br/>
            </div>
        </c:if>

        <form action="message.do" method="post">
            <textarea name="message" value="" placeholder="发送一个微博～（234字以内）" autofocus cols="60" rows="10">${requestScope.msg}</textarea>
            <br/><br/>
            <input type="submit" name="发布"/>
        </form>
        <br/>

        <%--消息--%>
        <c:if test="${requestScope.blahs != null}">
            <c:forEach var="blah" items="${requestScope.blahs}">
                <p>
                        ${blah.message}
                </p>
                ${blah.username} - ${blah.date} <br/>
                <hr style="width: 70%;"/>
            </c:forEach>
        </c:if>

    </div>
    <div id="footer" style="background-color: bisque; text-align:center;">
        版权 © SimpleWeibo
    </div>
</div>
<script>
    window.onload = function () {
        var o = document.getElementById("message");
        var h = o.clientHeight||o.offsetHeight;
        document.getElementById("userData").style.height = h + "px";
    }

</script>
</body>
</html>
