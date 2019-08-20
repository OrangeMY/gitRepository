<%--
  Created by IntelliJ IDEA.
  User: Administrator.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>课程列表</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <h1>imooc-教师管理</h1>
        </div>
    </div>
    <!-- 显示教师数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" id="check_all"/>
                    </th>
                    <th>教师编号</th>
                    <th>教师姓名</th>
                    <th>教师性别</th>
                    <th>主讲课程</th>
                    <th>所属学院</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${teachers}" var="teacher">
                    <tr>
                        <td><input type='checkbox' class='check_item'/></td>
                        <td>${teacher.id}</td>
                        <td>${teacher.name}</td>
                        <td>${teacher.sex}</td>
                        <td>${teacher.majorCourse}</td>
                        <td>${teacher.institute}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/getByTeacherId/${teacher.id}" method="get">
                                <button class="btn btn-primary btn-sm edit_btn" type="submit">
                                    <span class="glyphicon glyphicon-pencil">编辑</span>
                                </button>
                            </form>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/deleteTeacher/${teacher.id}" method="post">
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
                <form action="${pageContext.request.contextPath}/beforeAddTeacher" method="post">
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
