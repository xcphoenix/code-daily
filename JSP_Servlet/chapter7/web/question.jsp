<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set target="${pageContext.request}" property="characterEncoding" value="UTF-8" />
<%--设置字符编码，以正确获取中文字符--%>
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
	<form action="question.jsp" method="post">
		<c:choose>
			<c:when test="${param.page == null}">
				<label for="p1q1">问题一</label>
				<input type="text" name="p1q1" id="p1q1" /><br>
				<label for="p1q2">问题二</label>
				<input type="text" name="p1q2" id="p1q2" /><br>
				<input type="submit" name="page" value="NEXT"/>
			</c:when>
			<c:when test="${param.page == 'NEXT'}">
				<c:set var="p1q1" value="${param.p1q1}" scope="session" />
				<c:set var="p1q2" value="${param.p1q2}" scope="session" />
				<%--设置范围属性--%>
				<label for="p2q1">问题三</label>
				<input type="text" name="p2q1" id="p2q1" /><br>
				<input type="submit" name="page" value="FINISH" />
			</c:when>
			<c:when test="${param.page == 'FINISH'}">
				${sessionScope.p1q1}<br/>
				${sessionScope.p1q2}<br/>
				${param.p2q1}<br/>
			</c:when>
		</c:choose>
	</form>
</body>
</html>