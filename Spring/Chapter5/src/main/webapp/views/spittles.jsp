<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xuanc
  Date: 19-4-21
  Time: 下午8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recent Spittles</title>
</head>
<body>
    <h1>Recent Spittles</h1>
    <c:forEach items="${spittleList}" var="spittle">
        <li id="spittle_<c:out value="spittle.id"/>">
            <div class="spittleMessage">
                <c:out value="${spittle.message}" />
            </div>
            <div>
                <span class="spittleTime"><c:out value="${spittle.time}" /></span>
                <span class="spittleLocation">
                    (
                        <c:out value="${spittle.latitude}" />,
                        <c:out value="${spittle.longtime}" />
                    )
                </span>
            </div>
        </li>
    </c:forEach>
</body>
</html>
