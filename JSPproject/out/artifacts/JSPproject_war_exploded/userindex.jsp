<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: vit
  Date: 2017/12/21
  Time: 21:49
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
    <title>My JSP 'userindex.jsp' starting page</title>
</head>
<body>

<%
    String userID = (String)request.getParameter("id");
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/mysql";
    String user="root";
    String pass="123";
    Connection conn= DriverManager.getConnection (url,user,pass) ;
    Statement stmt=conn.createStatement () ;

    String sql = "select * from testwebproject where id="+userID+"";
    ResultSet rs = stmt.executeQuery(sql);
    if (rs.next()){
%>
个人主页<<br>
<table border="2px">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>专业</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td><%=rs.getInt("id")%></td>
        <td><%=rs.getString("name")%></td>
        <td><%=rs.getString("sex")%></td>
        <td><%=rs.getInt("age")%></td>
        <td><%=rs.getString("zhuanye")%></td>
        <td>
            <a href="xinxiedit.jsp?id=<%=userID%>">修改</a>
        </td>
        <td>
            <a href="userindex.jsp?del=<%=userID%>">删除</a>
        </td>
    </tr>
</table>
<%
    }
    else {
        System.out.println("无效的学生ID");
    }
    rs.close();
    stmt.close();
    conn.close();
%>
</body>
</html>
