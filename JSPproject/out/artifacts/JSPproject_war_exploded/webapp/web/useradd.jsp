<%--
  Created by IntelliJ IDEA.
  User: vit
  Date: 2017/12/22
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'usradd.jsp' starting page</title>

    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<form method="post" action="useraddcheck.jsp">
    学号：<input name=Id type="text" ><br><br>
    姓名：<input name=Name type="text" ><br><br>
    性别：<input name=Sex type="text" ><br><br>
    年龄：<input name=Age type="text" ><br><br>
    专业：<input name=Zhuanye type="text" ><br><br>
    密码：<input name=pass type="text" ><br><br>
    <input type="submit" value="注册">&nbsp;
    <input type="reset" value="重置">
</form>
</body>
</html>
