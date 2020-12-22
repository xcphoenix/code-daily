<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="message2"/>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title><fmt:message key="cc.openhome.title" /></title>
</head>
<body>
	<fmt:bundle basename="message1">
		<h1><fmt:message key="cc.openhome.forGuest"/></h1>
	</fmt:bundle>
</body>
</html>