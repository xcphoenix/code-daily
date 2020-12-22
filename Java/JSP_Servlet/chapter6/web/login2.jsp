<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="user" class="User"/>
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

<%
	if (user.isValid()) {
%>
	<h1><jsp:getProperty name="user" property="name"/>，登录成功</h1>
<%
	}
	else {
%>
	<h1>登录失败</h1>
<%
	}
%>
</body>
</html>