<%-- JSTLDemo --%>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>JSP count</title>
</head>
<body>
	<c:if test="${sessionScope.count == null}">
		<%
			session.setAttribute("count", 0);
		%>
	</c:if>
	<h1>JSP Count ${sessionScope.count}</h1>
	<%
		Integer ct = (Integer) session.getAttribute("count") + 1;
		session.setAttribute("count", ct);
	%>
	<a href="<c:url value='count.jsp'/>">递增</a>
</body>
</html>