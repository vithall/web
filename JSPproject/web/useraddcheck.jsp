<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: vit
  Date: 2017/12/22
  Time: 9:49
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

    <title>My JSP 'useraddcheck.jsp' starting page</title>

    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<%
    request.setCharacterEncoding("utf-8");
    String id=request.getParameter("Id");
    String name=request.getParameter("Name");
    String sex=request.getParameter("Sex");
    String age=request.getParameter("Age");
    String zhuanye=request.getParameter("Zhuanye");
    String upass=request.getParameter("pass");

    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/mysql";
    String user="root";
    String pass="123";
    Connection conn= DriverManager.getConnection(url,user,pass);
    Statement stmt=conn.createStatement();

    String sql="insert into testwebproject values('"+id+"','"+upass+"','"+name+"','"+sex+"','"+age+"','"+zhuanye+"')";
    stmt.executeUpdate(sql);

    stmt.close();
    conn.close();
    response.sendRedirect("userlogin.jsp");

%>
</body>
</html>
