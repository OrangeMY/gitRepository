<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>imooc-修改教学计划</h1>
        </div>
    </div>

    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/updateTeachingPlan" method="post">
        <div class="form-group">
            <label class="col-sm-1 control-label">教学计划编号</label>
            <div class="col-sm-3">
                <input type="text" value="${teachingPlan.id}" name="id" readonly="readonly" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">教学计划名称</label>
            <div class="col-sm-3">
                <input type="text" value="${teachingPlan.name}" name="name" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">年级</label>
            <div class="col-sm-3">
                <input type="text" value="${teachingPlan.grade}" name="grade" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">专业</label>
            <div class="col-sm-3">
                <input type="text" value="${teachingPlan.major}" name="major" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">制定人</label>
             <div class="col-sm-3">
                <select name="tId">
                    <c:forEach items="${teachers}" var="t">
                        <c:if test="${teachingPlan.tId == t.id}">
                            <option value="t.id" selected="selected">${t.name}</option>
                        </c:if>
                        <c:if test="${teachingPlan.tId != t.id}">
                            <option value="t.id">${t.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">制定时间</label>
            <div class="col-sm-3">
                <input type="text" value="${teachingPlan.appointTime}" name="appointTime" readonly="readonly" class="form-control">
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
