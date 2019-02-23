<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>加法页面</title>
</head>
<body>
	<c:catch var="error">
		${param.a} + ${param.b} = ${param.a + param.b}
	</c:catch>
	<c:if test="${error != null}">
		<br><span style="color: red;">${error.message}</span>
		<br>${error}
	</c:if>
</body>
</html>