<%@ page import="java.sql.*" %>
<%@ page import="java.lang.String" %>
<%--
  Created by IntelliJ IDEA.
  User: vit
  Date: 2017/12/19
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8"   language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>检查登录</title>
</head>
<body>
<%
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/mysql";
    String user="root";
    String pass="123";
    Connection conn=DriverManager.getConnection (url,user,pass) ;
    Statement stmt=conn.createStatement () ;

    String userID=request.getParameter ("userid" );
    String userPASS=request.getParameter ("userpass" );
    ResultSet rs1=stmt.executeQuery (
            "select * from testwebproject where id='"+userID+"'");
    if(rs1.next() ) {
        ResultSet rs2 = stmt.executeQuery(
                "select * from testwebproject where pass='"+ userPASS +"'");
        if (rs2.next()) {
            response.sendRedirect("userindex.jsp?id='" + userID + "'");
        }
        else{
            response.sendRedirect("userlogin.jsp");
        }
    }
    else{
        response.sendRedirect("userlogin.jsp");
    }
%>
</body>
</html>
