<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%-- 设置 isErrorPage 属性--%>
<%@page import="java.io.PrintWriter" %>
<html>
<head>
	<title>错误</title>
</head>
	<h1>网页发生错误：</h1><%= exception%>
	<h2>显示异常堆栈跟踪：</h2>
<%
	exception.printStackTrace(new PrintWriter(out));
%>
</html>