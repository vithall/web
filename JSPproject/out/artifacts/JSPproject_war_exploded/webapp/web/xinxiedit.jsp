<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%--
  Created by IntelliJ IDEA.
  User: vit
  Date: 2017/12/21
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private String Id = "";
    String Name = "";
    String Sex = "";
    String Age = "";
    String Zhuanye = "";
    String sql = "";
    ResultSet rs = null;
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'xinxiedit.jsp' starting page</title>
</head>
<body>
<%
    if (request.getParameter("id")!=null){
        String userID = request.getParameter("id");
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/mysql";
        String user="root";
        String pass="123";
        Connection conn= DriverManager.getConnection (url,user,pass);
        Statement stmt=conn.createStatement ();

        String sql = "select * from testwebproject where id = "+userID+"";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()){
            Id = rs.getString("id");
            Name = rs.getString("name");
            Sex = rs.getString("sex");
            Age = rs.getString("age");
            Zhuanye = rs.getString("zhuanye");
            rs.close();
%>
<form method="post" action="editsave.jsp">
    学号：<input name="Id" type="text" value="<%=Id%>"><br>
    姓名：<input name="Name" type="text" value="<%=Name%>"><br>
    性别：<input name="Sex" type="text" value="<%=Sex%>"><br>
    年龄：<input name="Age" type="text" value="<%=Age%>"><br>
    专业：<input name="Zhuanye" type="text" value="<%=Zhuanye%>"><br>
    <input type="submit" value="提交">&nbsp;&nbsp;<input type="reset" value="取消">
</form>

<%
        }
        else {
            System.out.println("无效的学生ID");
        }
    }
%>
</body>
</html>
