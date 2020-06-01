<%@tag description="HTML懒人标签" pageEncoding="UTF-8"%>
<%--声明title属性--%>
<%@attribute name="title"%>
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>${title}</title>
</head>
<body>
	<%--可以使用 Tag File 标签时的内容--%>
	<jsp:doBody/>
</body>
</html>
<%--
 tag file 可以有 Body
 Body 中不允许有 Scriptlet
 tag 标签中 body-content 的值:
    1. empty: 表示一定没有 Body 内容
    2. scriptless: 不能有 Scriptlet, 不能有 <% %> <!% %> <%= %>
    3. tagdependent: 将 Body 中的 Scriptlet，EL 自定义标签以纯文本处理
--%>