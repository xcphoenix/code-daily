<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="messageService" class="cc.openhome.MessageService" />
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>留言板</title>
</head>
<body>
	<table style="text-align: left; width: 100%;" border="1">
		<tr>
			<td>名称</td>
			<td>信息</td>
		</tr>
		<c:forEach var="message" items="${messageService.messages}">
			<tr>
				<td>${message.name}</td>
				<td>${message.text}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>