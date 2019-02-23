<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
</head>
<body>
	<fmt:setLocale value="zh_TW" />
	<fmt:formatDate value="${now}" type="both" /><br/>
	<fmt:formatNumber value="12345.678" type="currency"/><br/>
	<fmt:setLocale value="zh_CN" />
	<fmt:formatDate value="${now}" type="both" /><br/>
	<fmt:formatNumber value="12345.678" type="currency"/><br/>
	<fmt:setLocale value="ja_JP" />
	<fmt:formatDate value="${now}" type="both" /><br/>
	<fmt:formatNumber value="12345.678" type="currency"/><br/>
</body>
</html>