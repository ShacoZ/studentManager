<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.lyd.bean.User" %>
<%@ page import="com.lyd.bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-success">
<%
    ArrayList<Student> stuList = (ArrayList<Student>)session.getAttribute("stuList");
    String msg = (String)session.getAttribute("msg");
    if(!msg.equals("")){
        out.print("<script language='javascript'>alert('" + msg + "')</script>");
    }
    session.setAttribute("msg","");
%>


<div class="text-right">
    <a href="/add.jsp">添加学生</a>
    <form action="/query" method="post">
        <input type="text" name="name">
        <input type="submit">
    </form>
</div>
<table class="table table-hover ">
    <thead>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
    </thead>
    <% for (Student student : stuList) { %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getAge() %></td>
        <td><%= student.getSex() %></td>
        <td><a href="/modify?id=<%= student.getId() %>">修改</a></td>
        <td><a href="/delete?id=<%= student.getId() %>">删除</a></td>
    </tr>
    <% } %>
</table>


</body>
</html>
