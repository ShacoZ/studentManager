<%@ page import="com.lyd.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    <style>
        .card,.list-group,.row{
            border-radius: 1rem;
        }
        .height-full{
            height: 30rem;
        }
    </style>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
%>



<div class="container-fluid">

    <div class="row mt-3">
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-body">
                    <div class="row">
                        <div class="col text-left">
                            <h2>学生管理系统</h2>
                        </div>
                        <div class="col text-right">
                            当前用户：<%= user.getUsername()%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-3">
            <div class="card bg-info text-white">
                <div class="card-body height-full">
                    <h3 class="card-title">学生管理</h3>
                    <ul id="list" class="list-group">
                        <li class="list-group-item list-group-item-info">
                            <a href="main.jsp" target="main">学生列表</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-9">
            <div class="card bg-success text-white">
                <div class="card-body height-full">
                    <iframe name="main" width="100%" frameborder="0" height="100%" src="main.jsp"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
