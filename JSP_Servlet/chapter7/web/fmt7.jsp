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
	<title>fmt7.jsp</title>
</head>
<body>
	<fmt:formatDate value="${now}"/><br/>
	<fmt:formatDate value="${now}" dateStyle="full" /><br/>
	<fmt:formatDate value="${now}" type="time" timeStyle="full" /><br>
	<fmt:formatDate value="${now}" pattern="dd.MM.yy" /><br/>
	<fmt:timeZone value="GMT+1.00">
		<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br/>
	</fmt:timeZone>
	<%--
	 <fmt:formatDate> 用来格式化日期，可根据不同的地区呈现不同的格式
	 dateStyle: 指定日期的详细程度，可选值：default,short,medium,long,full
	 type: “time" -> 显示时间 "date"(default) -> 显示日期 "full" -> 都显示
	 timeStyle: 指定时间的详细程度，可选值同 dateStyle
	 -----------------------------------------------------------------
	 pattern: 自定义格式 参考 SimpleDateFormat
	 -----------------------------------------------------------------
	 <fmt:timeZone> 指定时区，字符串或 java.util.TimeZone 对象
	 
	 --%>
</body>
</html>