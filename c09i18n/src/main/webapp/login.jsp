<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td><s:text name="userName"></s:text></td>
		<td>
			<input type="text"/>
		</td>
	</tr>
	<tr>
		<td><s:text name="password"></s:text></td>
		<td>
			<input type="text"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="<s:text name='login'></s:text>"/>
		</td>
	</tr>
</table>
</body>
</html>