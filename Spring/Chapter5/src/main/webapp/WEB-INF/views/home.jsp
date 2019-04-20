<%--
  Created by IntelliJ IDEA.
  User: xuanc
  Date: 19-4-18
  Time: 下午9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
    <h1>Welcome to Spittr</h1>

    <a href="<c:url value='/spittles'/>" >Spittles</a> |
    <a href="<c:url value='/spitter/register' />">Register</a>
</body>
</html>
