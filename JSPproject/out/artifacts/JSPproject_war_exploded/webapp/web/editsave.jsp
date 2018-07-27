<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: vit
  Date: 2017/12/21
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String id = "";
    String name = "";
    String sex = "";
    String age = "";
    String zhuanye = "";
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;
    boolean flag4 = false;
    boolean flag5 = false;
    String sql = "";
    ResultSet rs = null;
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'editsave.jsp' starting page</title>

</head>

<body>
<%
    request.setCharacterEncoding("UTF-8");
    if(request.getParameter("Id")!=""){
        flag1=true;
        id=request.getParameter("Id");
    }
    if(request.getParameter("Name")!=""){
        flag2=true;
        name=request.getParameter("Name");
    }
    if(request.getParameter("Sex")!=""){
        flag3=true;
        sex=request.getParameter("Sex");
    }
    if(request.getParameter("Age")!=""){
        flag4=true;
        age=request.getParameter("Age");
    }
    if(request.getParameter("Zhuanye")!=""){
        flag5=true;
        zhuanye=request.getParameter("Zhuanye");
    }
    if(flag1 & flag2 & flag3 & flag4 & flag5){
        Connection conn=null;
        PreparedStatement ps=null;
        Statement stmt=null;

        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/mysql";
        String user="root";
        String pass="123";
        conn=DriverManager.getConnection(url,user,pass);
        stmt=conn.createStatement();

        String sql="update testwebproject set id='"+id+"',name='"+name+"',sex='"+sex+"',age='"+age+"',zhuanye='"+zhuanye+"' where id='"+id+"'";

        ps=conn.prepareStatement(sql);
        int n=ps.executeUpdate();
        System.out.println("修改成功");
        response.sendRedirect("userindex.jsp?id='"+id+"'");
    }
    else{
        response.sendRedirect("xinxiedit.jsp");
    }
%>
</body>
</html>
