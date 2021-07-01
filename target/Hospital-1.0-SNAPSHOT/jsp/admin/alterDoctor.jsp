<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.example.entity.Register" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>修改医生信息</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <%--        <link rel="stylesheet" type="text/css" href="styles.css">--%>

        <link href="../../css/index.css" type="text/css" rel="stylesheet">
        <link href="../../css/background.css" rel="stylesheet">
        <link href="../../css/readerBlock.css" rel="stylesheet">

        <script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>
        <%@ include file="../../leftHead.jsp" %>
    </head>

    <body>
        <%@ include file="../../heading.jsp" %>

        <div id="main">
            <%--侧边菜单栏--%>
            <!--侧栏界面设计-->
            <div id="mySidenav" class="sidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <a href="/admin">查询患者信息</a>
                <br/><br/>
                <a href="/admin?method=alterDoctor">修改医生信息</a>
                <br/><br/>
                <a href="/admin?method=alterDepartment">修改科室信息</a>
            </div>

            <div>
                <%--    <h2>侧边栏实例 - 页面主体向右移动</h2>--%>
                <%--    <p>点击以下菜单图标打开侧边栏，主体内容向右偏移。主体内容添加黑色透明背景</p>--%>
                <script>openNav()</script>
                <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; 菜单栏</span>
            </div>

            <div class="navigation">
                <div class="readerBlock1">
                    当前位置:&nbsp;&nbsp;修改医生信息
                </div>

                <div class="readerBlock2">
                    <a class="a" href="/logout">注销</a>
                </div>
            </div>

            <table class="table" cellspacing="0">
                <tr>
                    <td>姓名</td>
                    <td>年龄</td>
                    <td>性别</td>
                    <td>职称</td>
                    <td>专长</td>
                    <td>用户名</td>
                    <td>科室</td>
                    <td>操作</td>
                </tr>


                <c:forEach items="${doctorList}" var="doctor">
                    <tr>
                        <td>${doctor.name}</td>
                        <td>${doctor.age}</td>
                        <td>${doctor.sex}</td>
                        <td>${doctor.title}</td>
                        <td>${doctor.speciality}</td>
                        <td>${doctor.department.name}</td>
                        <td>${doctor.username}</td>
                        <td>
                            <a href="/admin?method=deleteDoctor&doctorId=${doctor.id}">删除</a>
                            <a href="/admin?method=alterDoctorInfo&doctorId=${doctor.id}">修改</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <button class="button" onclick="location.href='/admin?method=addDoctor'">添加医生</button>
        </div>

        <%@ include file="../../footer.jsp" %>
    </body>
</html>
