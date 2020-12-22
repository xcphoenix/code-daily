<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" errorPage="error.jsp" import="java.util.Collection" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="util" uri="/WEB-INF/util" %>
<%--使用 taglib 指示元素 --%>
<%
	Collection<String> names = new ArrayList<String>();
	names.add("caterpillar");
	names.add("momor");
	names.add("admin");
	request.setAttribute("someList", names);
%>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>自定义 EL 函数</title>
</head>
<body>
	${util:length(requestScope.someList)}
</body>
</html>