
<%--
  Created by IntelliJ IDEA.
  User: Administrator.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>imooc-添加教学计划</h1>
        </div>
    </div>

    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/addTeachingPlan" method="post">
        <div class="form-group">
            <label class="col-sm-1 control-label">教学计划编号</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="id" placeholder="请输入教学计划编号">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">教学计划名称</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="name" placeholder="请输入教学计划名称">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">年级</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="grade" placeholder="请输入年级">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">专业</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" name="major" placeholder="请输入专业">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">制定人</label>
            <div class="col-sm-3">
                <select name="tId">
                    <c:forEach items="${teachers}" var="teacher">
                        <option value="${teacher.id}">${teacher.name}</option>
                    </c:forEach>
                </select>
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
