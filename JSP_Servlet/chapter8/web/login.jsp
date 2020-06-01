<%@ page import="java.util.Collection" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="f" uri="http://openhome.cc/jstl/fake" %>
<%@taglib prefix="tf" uri="http://openhome.cc/jstl/fakeT" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>测试 fake-when </title>
</head>
<body>
	<f:choose>
		<f:when test="${'caterpillar'.equals(param.name) && '1234567'.equals(param.passwd)}">
			<h1>Hello~, caterpillar</h1>
		</f:when>
		<f:when test="${'momor'.equals(param.name) && '1234567'.equals(param.passwd)}">
			<h1>Hello~, Momor</h1>
		</f:when>
		<f:otherwise>
			<h1>Sorry</h1>
		</f:otherwise>
	</f:choose>
	<%
		ArrayList<String> collection = new ArrayList<String>();
		collection.add(0, "Hello0");
		collection.add(1, "qwt");
		collection.add(2, "yegrb");
		pageContext.setAttribute("collection", collection, pageContext.PAGE_SCOPE);
	%>
	<tf:forEach var="tmp" items="${pageScope.collection}">
		<tf:toUpperCase>
			<h2>${tmp}</h2>
		</tf:toUpperCase>
	</tf:forEach>

</body>
</html>