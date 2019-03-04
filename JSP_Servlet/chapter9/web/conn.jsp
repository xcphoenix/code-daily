<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="db" class="cc.openhome.DbBean" />
<c:set target="${db}" property="jdbcUrl" value="jdbc:mysql://localhost:3306/employees"/>
<c:set target="${db}" property="username" value="root"/>
<c:set target="${db}" property="password" value="mysqlpass"/> C
<html>
<head>
	<title>测试数据库连接</title>
</head>
<body>
	<c:choose>
		<c:when test="${db.connectedOK}">连接成功</c:when>
		<c:otherwise>连接失败</c:otherwise>
	</c:choose>
</body>
</html>
