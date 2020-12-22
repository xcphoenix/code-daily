<%--
  Created by IntelliJ IDEA.
  User: xuanc
  Date: 19-3-4
  Time: 下午3:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SimpleWeibo</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1 align="center">Simple Weibo</h1>

    <h2 align="center">会员登录</h2>
    <center>
        <c:if test="${requestScope.error != null}">
            <h3>登录失败！请检查用户名和密码是否匹配!</h3>
            <hr/>
        </c:if>
        <form action="login.do" method="post">
            <table>
                <tr>
                    <td><label for="username">名称&emsp;</label> </td>
                    <td>
                        <input id="username" type="text" name="username"/>
                    </td>
                </tr>
                <tr>
                    <td><label for="password">密码&emsp;</label> </td>
                    <td>
                        <input id="password" type="password" name="password"/>
                    </td>
                </tr>
            </table> <br/>
           <input type="submit" value="登录"/>
        </form>
        <br/><a href="register.jsp" target="_blank">还不是会员</a>
    </center>

</body>
</html>
