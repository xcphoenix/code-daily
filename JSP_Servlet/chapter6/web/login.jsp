<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%!
	String name = "caterpillar";
	String password = "123456";

	boolean checkUser(String name, String password) {
	    return this.name.equals(name) && this.password.equals(password);
	}
%>

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
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	if (checkUser(name, password)) {
%>
	<h1><%= name %> 登录成功 </h1>
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