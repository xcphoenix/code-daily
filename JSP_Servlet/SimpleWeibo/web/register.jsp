<%--
  Created by IntelliJ IDEA.
  User: xuanc
  Date: 19-3-4
  Time: 下午4:46
  注册页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SimpleWeibo 会员注册</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1 align="center">Simple Weibo</h1>
<h2 align="center">会员注册</h2>
    <center>
        <%--输出错误信息--%>
        <c:if test="${requestScope.errors != null}">
            <c:forEach var="error" items="${requestScope.errors}">
                <label style="color:red;">${error}<br/></label>
            </c:forEach>
            <hr/>
        </c:if>

        <form action="register.do" method="post">
            <table>
                <tr>
                    <td><label for="username">名称&emsp;</label> </td>
                    <td>
                        <input id="username" type="text" name="username" placeholder="用户名应为数字和字母的组合"/>
                    </td>
                </tr>
                <tr>
                    <td><label for="email">邮箱&emsp;</label> </td>
                    <td>
                        <input id="email" type="text" name="email" placeholder="请输入正确的邮箱格式"/>
                    </td>
                </tr>
                <tr>
                    <td><label for="password">密码&emsp;</label> </td>
                    <td>
                        <input id="password" type="password" name="password" placeholder="长度大于５且小于17"/>
                    </td>
                </tr>
                <tr>
                    <td><label for="confirmPassword">确认密码&emsp;</label> </td>
                    <td>
                        <input id="confirmPassword" type="password" name="confirmPassword"/>
                    </td>
                </tr>
            </table> <br/>
            <input type="submit" value="注册"/>
        </form>
    </center>
</body>
</html>
