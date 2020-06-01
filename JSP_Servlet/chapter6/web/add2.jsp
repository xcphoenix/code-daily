<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" %>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>加法网页</title>
</head>
<body>
	${param.a} + ${param.b} = ${param.a + param.b}
</body>
</html>