<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="cc.openhome.User"/>
<jsp:setProperty name="user" property="*"/>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>登录页面</title>
</head>
<body>
	<c:choose>
		<c:when test="${user.valid}">
			<jsp:getProperty name="user" property="name"/> 登录成功
			<%--
			* 属性的名称就是get/set方法去除get/set后 ,再把首字母小写
			* boolean的方法可以是is开头
			--%>
		</c:when>
		<%--<c:otherwise>--%>
			<%--<h1> 登录失败 </h1>--%>
		<%--</c:otherwise>--%>
	</c:choose>
</body>
</html>