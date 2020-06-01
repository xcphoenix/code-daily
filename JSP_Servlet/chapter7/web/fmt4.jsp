<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*, javax.servlet.jsp.jstl.fmt.*" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<%
	ResourceBundle zh_CN = ResourceBundle.getBundle("hello", new Locale("zh", "CN"));
	ResourceBundle ja_JP = ResourceBundle.getBundle("hello", new Locale("ja", "JP"));
	ResourceBundle en_US = ResourceBundle.getBundle("hello", new Locale("en", "US"));
	
	pageContext.setAttribute("zh_CN", new LocalizationContext(zh_CN));
	pageContext.setAttribute("ja_JP", new LocalizationContext(ja_JP));
	pageContext.setAttribute("en_US", new LocalizationContext(en_US));
	// 创建 LocalizationContext
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
</head>
<body>
	<fmt:message bundle="${zh_CN}" key="cc.openhome.hello"/><br/>
	<fmt:message bundle="${ja_JP}" key="cc.openhome.hello"/><br/>
	<fmt:message bundle="${en_US}" key="cc.openhome.hello"/><br/>
</body>
</html>