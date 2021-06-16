<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="com.lyd.bean.User"
%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    <style>
        .card{
            width: 25rem;
        }
        .card{
            margin: 10rem;
        }
    </style>
</head>
<body>
<%
    if(session.getAttribute("msg")!=null){
        String msg = (String)session.getAttribute("msg");
        if(!msg.equals("")){
            out.print("<script language='javascript'>alert('" + msg + "')</script>");
        }
        session.setAttribute("msg","");
    }
%>

<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mx-auto">
                <div class="card-body text-center">
                    <h4 class="card-title">后台登录</h4>
                    <form action="/admin" method="post">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">账号</span>
                            </div>
                            <input type="text" class="form-control" placeholder="用户名" name="username">
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">密码</span>
                            </div>
                            <input type="password" class="form-control" placeholder="密码" name="password">
                        </div>
                        <button type="submit" class="btn btn-primary">登录</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
