<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.lyd.bean.User" %>
<%@ page import="com.lyd.bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body >
<%
    ArrayList<Student> stuList = (ArrayList<Student>)session.getAttribute("stuList");
    String msg = (String)session.getAttribute("msg");
    if(!msg.equals("")){
        out.print("<script language='javascript'>alert('" + msg + "')</script>");
    }
    session.setAttribute("msg","");
%>

<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-body bg-dark text-center text-white">
                    <h3>我的学生</h3>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-hover text-center">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                </tr>
                </thead>
                <% for (Student student : stuList) { %>
                <tr>
                    <td><%= student.getId() %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.getAge() %></td>
                    <td><%= student.getSex() %></td>
                </tr>
                <% } %>
            </table>
        </div>
    </div>

</div>




</body>
</html>
