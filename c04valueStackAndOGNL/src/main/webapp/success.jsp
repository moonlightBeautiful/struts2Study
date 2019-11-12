<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%
        // request上设置值
        request.setAttribute("name", "李四(request)");
        request.setAttribute("age", "12");
    %>
</head>
<body>
获取狭义值栈上的数据：<s:property value="name"/>
<s:property value="age"/><br/>

获取请求参数（#parameters.参数名=request.getParameter(参数名)）：<s:property value="#parameters.name"/>
<s:property value="#parameters.age"/><br/>

获取request保存的数据（#request.参数名 = request.getAttribute(参数名)）：<s:property value="#request.name"/>
<s:property value="#request.age"/><br/>

获取session保存的数据（#session.参数名 = session.getAttribute(参数名)）：<s:property value="#session.name"/>
<s:property value="#session.age"/><br/>

获取application保存的数据（#application.参数名 = application.getAttribute(参数名)）：<s:property value="#application.name"/>
<s:property value="#application.age"/><br/>

获取attr保存的数据（#attrn.参数名 = （从page、request、session、application顺序找）：<s:property value="#attr.name"/>
<s:property value="#attr.age"/><br/>

ognl访问javaBean对象：
<s:property value="student.name"/>
<s:property value="student.age"/><br/>

ognl访问List<javaBean>集合：
<s:property value="students[0].name"/>
<s:property value="students[0].age"/><br/>
<s:property value="students[1].name"/>
<s:property value="students[1].age"/><br/>

ognl访问Map<String javaBean>：
<s:property value="studentMap['goodStudent'].name"/>
<s:property value="studentMap['goodStudent'].age"/><br/>
<s:property value="studentMap['badStudent'].name"/>
<s:property value="studentMap['badStudent'].age"/><br/>
</body>
</html>