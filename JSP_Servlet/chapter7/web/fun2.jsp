<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
</head>
<body>
	<c:choose>
		<c:when test="${fn:startsWith(param.text, 'caterpillar')}">
			${fn:replace(param.text, 'caterpillar', '张三')}
		</c:when>
		<c:otherwise>
			${param.text}
		</c:otherwise>
	</c:choose>
</body>
</html>