<%--
  Created by IntelliJ IDEA.
  User: Administrator.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>add</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body{
            overflow-x:hidden;
        }
        #main{
            width:1200px;
            height:600px;
            margin-left:500px;
        }
    </style>
</head>
<body>

<div id="main">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <h1>imooc-添加课程</h1>
        </div>
    </div>

    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/addTeacher" method="post">
        <div class="form-group">
            <label class="col-sm-1 control-label">教师编号</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="id" placeholder="请输入教师编号">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">教师名称</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="name" placeholder="请输入教师名称">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">性别</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="sex" placeholder="请输入性别">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">主修课程</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="majorCourse" placeholder="请输入主修课程">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">所属学院</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="institute" placeholder="请输入所属学院">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-3">
                <button type="submit" class="btn btn-default">提交</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
