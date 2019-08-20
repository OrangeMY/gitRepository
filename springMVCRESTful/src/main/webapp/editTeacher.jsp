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
            <h1>imooc-修改教师</h1>
        </div>
    </div>

    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/updateTeacher" method="post">
        <div class="form-group">
            <label class="col-sm-1 control-label">教师编号</label>
            <div class="col-sm-3">
                <input type="text" value="${teacher.id}" name="id" readonly="readonly" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">教师姓名</label>
            <div class="col-sm-3">
                <input type="text" value="${teacher.name}" name="name" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">性别</label>
            <div class="col-sm-3">
                <input type="text" value="${teacher.sex}" name="sex" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">主讲课程</label>
            <div class="col-sm-3">
                <input type="text" value="${teacher.majorCourse}" name="majorCourse" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">所属学院</label>
            <div class="col-sm-3">
                <input type="text" value="${teacher.institute}" name="institute" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-3">
                <input type="hidden" name="_method" value="PUT"/>
                <button type="submit" class="btn btn-default">提交</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
