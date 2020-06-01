<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:setBundle basename="message3"/>
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
	<fmt:message key="cc.openhome.forUser">
		<fmt:param value="${param.username}"/>
		<fmt:param value="${now}"/>
		<fmt:param value="${now}"/>
	</fmt:message>
</body>
</html>