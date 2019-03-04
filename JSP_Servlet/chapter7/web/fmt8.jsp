<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<%--格式化数字--%>
	<fmt:formatNumber value="12345.678"/><br/>
	<fmt:formatNumber value="12345.678" type="currency" /><br/>
	<fmt:formatNumber value="12345.678" type="currency" currencySymbol="新台币"/><br/>
	<fmt:formatNumber value="12345.678" type="percent" /><br/>
	<fmt:formatNumber value="12345.678" pattern="#,#00.0#" /><br/>
	<%--
	 type: number(default), currency(货币), percent
	 currencySymbol: 指定货币符号
	 pattern: 指定格式输出
	--%>
</body>
</html>