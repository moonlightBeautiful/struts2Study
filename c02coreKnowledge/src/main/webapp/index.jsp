<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<a href="login1.jsp" target="_blank"> 属性驱动 </a><br/>
<a href="login2.jsp" target="_blank"> 模型驱动（了解即可） </a><br/>
<a href="wildcard.jsp" target="_blank"> 通配符匹配请求 </a><br/>
<a href="exclamationMark.jsp" target="_blank"> 感叹号匹配请求 </a><br/>
<a href="hello" target="_blank"> 每次请求都是一个新的action实例 </a><br/>
<a href="hello?name=Struts2" target="_blank">默认转发_dispatcher</a><br/>
<a href="hello!r?name=Struts2" target="_blank">重定向_redirect</a><br/>
<a href="hello!c?name=Struts2" target="_blank">转发到Action_chain</a><br/>
<a href="hello!ra?name=Struts2" target="_blank">重定向到Action_redirectAction</a><br/>
</body>
</html>