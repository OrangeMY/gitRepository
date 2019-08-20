<%--
  Created by IntelliJ IDEA.
  User: Administrator.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>教学计划列表</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <h1>imooc-教学计划管理</h1>
        </div>
    </div>
    <!-- 显示教学计划数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" id="check_all"/>
                    </th>
                    <th>教学计划编号</th>
                    <th>教学计划名称</th>
                    <th>年级</th>
                    <th>专业</th>
                    <th>制定人</th>
                    <th>制定时间</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${teachingPlans}" var="teachingPlan">
                    <tr>
                        <td><input type='checkbox' class='check_item'/></td>
                        <td>${teachingPlan.id}</td>
                        <td>${teachingPlan.name}</td>
                        <td>${teachingPlan.grade}</td>
                        <td>${teachingPlan.major}</td>
                        <td>${teachingPlan.teacher.name}</td>
                        <td><fmt:formatDate value="${teachingPlan.appointTime}" pattern="yyyy-MM-dd"/></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/getByTeachingPlanId/${teachingPlan.id}" method="get">
                                <button class="btn btn-primary btn-sm edit_btn" type="submit">
                                    <span class="glyphicon glyphicon-pencil">编辑</span>
                                </button>
                            </form>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/deleteTeachingPlan/${teachingPlan.id}" method="post">
                                <button class="btn btn-danger btn-sm delete_btn" type="submit">
                                    <input type="hidden" name="_method" value="DELETE"/>
                                    <span class="glyphicon glyphicon-trash">删除</span>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <hr/>
            <div class="foot" style="left: 1000px; height: 40px; width: 100px; position:relative">
                <form action="${pageContext.request.contextPath}/beforeAddTeachingPlan" method="post">
                    <button class="btn btn-danger btn-sm delete_btn" type="submit">
                        <span class="glyphicon glyphicon-trash">添加</span>
                    </button>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
