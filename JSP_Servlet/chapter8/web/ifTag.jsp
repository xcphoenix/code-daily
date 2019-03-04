<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="f" uri="http://openhome.cc/jstl/fake"%>
<%@taglib prefix="tf" uri="http://openhome.cc/jstl/fakeT"%>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>自定义标签</title>
</head>
<body>
	<f:if test="${param.password == '123456'}">
		你的秘密数据～～
		<%--<%--%>
			<%--out.println("I run..");--%>
		<%--%>--%>
	</f:if>
	<br/>
	<tf:if test="${param.password == '123456'}">
		你的秘密数据～～
		<%
			out.println("I run..");
		%>
	</tf:if>
</body>
</html>