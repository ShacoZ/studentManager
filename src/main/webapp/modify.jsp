
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.lyd.bean.Student" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-success">

<%
    Student student =  (Student)session.getAttribute("student");
%>

<div class="container-fluid">
    <div class="row">
        <div class="col">
            <form action="/modified" method="post">
                <input name="id" value="<%= student.getId() %>" hidden />
                <div class="form-group">
                    <label for="name">姓名:</label>
                    <input type="text" class="form-control" name="name" id="name" value="<%= student.getName() %>">
                </div>
                <div class="form-group">
                    <label for="sex">性别:</label>
                    <input type="text" class="form-control" name="sex" id="sex" value="<%= student.getSex() %>">
                </div>
                <div class="form-group">
                    <label for="age">年龄:</label>
                    <input type="text" class="form-control" name="age" id="age" value="<%= student.getAge() %>">
                </div>
                <button type="submit" class="btn btn-primary">提交</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
