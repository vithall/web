<%--
  Created by IntelliJ IDEA.
  User: vit
  Date: 2017/12/21
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Login</title>
</head>
<body>
<form method="post" action="userlogincheck.jsp">
    <label for="userid"></label>
    用户账号：
    <input type="text" id="userid" name="userid" ><br>
    <br>
    <label for="userpass"></label>
    密码：
    <input type="password" id="userpass" name="userpass">
    <br>
    <input type="submit" name="submit" value="提交">
    <input type="reset" name="reset" value="取消">
</form>
<a href="useradd.jsp">注册</a>
</body>
</html>
