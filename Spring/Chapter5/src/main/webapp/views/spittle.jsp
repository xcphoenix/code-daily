<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xuanc
  Date: 19-4-22
  Time: 下午3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittle</title>
</head>
<body>
    <div class="spittleView">
        <div class="spittleMessage"><c:out value="${spittle.message}"/></div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}"/></span>
        </div>
    </div>
</body>
</html>
