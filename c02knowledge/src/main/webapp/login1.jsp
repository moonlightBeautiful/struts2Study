<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>属性驱动</title>
</head>
<body>
<form action="userAction1" method="post">
    姓名：<input type="text" name="name"/><br/>
    年龄：<input type="text" name="age"/><br/>
    用户名：<input type="text" name="user.userName"/><br/>
    密码：<input type="text" name="user.password"/>
    爱好：<br/>
    <input type="checkbox" name="hobby" value="唱歌"/>唱歌
    <input type="checkbox" name="hobby" value="跳舞"/>跳舞
    <input type="checkbox" name="hobby" value="睡觉"/>睡觉
    <input type="checkbox" name="hobby" value="玩CF"/>玩CF
    学生：
    <table>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
        </tr>
        <tr>
            <td><input type="text" name="students[0].name"/></td>
            <td><input type="text" name="students[0].sex"/></td>
            <td><input type="text" name="students[0].age"/></td>
        </tr>
        <tr>
            <td><input type="text" name="students[1].name"/></td>
            <td><input type="text" name="students[1].sex"/></td>
            <td><input type="text" name="students[1].age"/></td>
        </tr>
    </table>
    <input type="submit" value="登录"/>
</form>
</body>
</html>