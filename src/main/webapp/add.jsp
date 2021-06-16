<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-success">



<div class="container-fluid">
    <div class="row">
        <div class="col">
            <form action="/add" method="post">
                <div class="form-group">
                    <label for="name">姓名:</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="输入姓名">
                </div>
                <div class="form-group">
                    <label for="sex">性别:</label>
                    <input type="text" class="form-control" name="sex" id="sex" placeholder="输入性别">
                </div>
                <div class="form-group">
                    <label for="age">年龄:</label>
                    <input type="text" class="form-control" name="age" id="age" placeholder="输入年龄">
                </div>
                <button type="submit" class="btn btn-primary">提交</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
