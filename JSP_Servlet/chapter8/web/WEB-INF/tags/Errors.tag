<%@tag description="显示错误信息的标签" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="headline"%>
<c:if test="${requestScope.errors != null}">
	<h1>${headline}</h1>
	<ul style='color: rgb(255, 0, 0);'>
		<c:forEach var="error" items="${requestScope.errors}">
			<li>${error}</li>
		</c:forEach>
	</ul><br>
</c:if>
<%--
 pageEncoding: 转译时需要的编码
 tag file 中可以使用自定义标签，El，Scriplet，可以使用 out,config, request, response, session, application, jspContext
 如果编写 Scriplet，转译后创建的隐式对象是 doTag() 方法中的局部变量
--%>