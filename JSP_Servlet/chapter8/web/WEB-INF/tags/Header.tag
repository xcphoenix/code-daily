<%@tag description="header 内容" pageEncoding="UTF-8"%>
<%--attribute 指示元素定义属性名称，值在*.tag文件中可以用${title}取得--%>
<%@attribute name="title"%>
<%--<%@attribute name="other..."%>--%>
<head>
	<title>${title}</title>
	<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8" >
</head>