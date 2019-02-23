<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:if test="${param.name == 'momor'&& param.password == '1234'}">
		<h1>${param.name} 登录成功 </h1>
	</c:if>
	<%-- JSTL中可以使用EL表达式--%>
</body>
</html>