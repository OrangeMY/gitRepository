<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
    <style type="text/css">
        body{
            overflow-x:hidden;
        }
    </style>
</head>
<body>
<form class="form-horizontal" role="form" action="login" method="post">
    <div class="form-group">
        <label class="col-sm-1 control-label">用户名</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="username" placeholder="请输入用户名">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-1 control-label">密码</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" name="password" placeholder="请输入密码">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-3">
            <button type="submit" class="btn btn-default">提交</button>
        </div>
    </div>
</form>
</body>
</html>
