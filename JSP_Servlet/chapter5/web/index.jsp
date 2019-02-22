<%--
  Created by IntelliJ IDEA.
  User: xuanc
  Date: 19-2-18
  Time: 下午4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%--访问.jsp，如果不加 session="false" 也会默认生成 HttpSession 对象--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <center>
      5.1.2 ConfigDemo - Login.java <br>
      <font color="#778899">username: caterpillar<br>password: 123456</font><br>
      <form action="login.do" method="post">
        username: <input type="text" name="name"/><br>
        password: <input type="password" name="passwd"><br>
        <input type="submit" value="测试">
      </form>
      <br>
      <hr>
      <a href="avatar.view" target="_blank">头像显示</a>
      <br>
    </center>
  </body>
</html>
