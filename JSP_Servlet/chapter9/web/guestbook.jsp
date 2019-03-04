<%--
  Created by IntelliJ IDEA.
  User: xuanc
  Date: 19-3-1
  Time: 上午10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--设置编码--%>
<c:set target="${pageContext.request}" property="characterEncoding" value="UTF-8"/>
<jsp:useBean id="guestbook" class="cc.openhome.GuestBookBean" scope="application"/>

<%--新增留言--%>
<c:if test="${param.msg != null}">
    <jsp:useBean id="newMessage" class="cc.openhome.Message"/>
    <jsp:setProperty name="newMessage" property="*"/>
    <c:set target="${guestbook}" property="message"  value="${newMessage}"/>
</c:if>

<html>
<head>
    <title>访客留言板</title>
</head>
<body>
    <table style="text-align: left; width: 100%;" border="0" cellpadding="2" cellspacing="2">
        <tbody>
            <%--调用getMessage()方法取得留言--%>
            <c:forEach var="message" items="${guestbook.messages}">
                <tr>
                    <td>${message.name}</td>
                    <td>${message.email}</td>
                    <td>${message.msg}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
