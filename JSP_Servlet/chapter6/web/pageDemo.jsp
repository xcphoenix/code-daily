<%@page import="java.util.Date" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Page 指示元素</title>
</head>
<body>
	<h1>现在时间： <%= new Date() %></h1>
	<hr/>
<%
	out.println("JSP中Java语法结束符号 &lt;% Java语句 %&gt; <br/>eg: &ampgt; and &amplt;");
%>
</body>
</html>