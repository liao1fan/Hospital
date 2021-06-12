<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.example.entity.Doctor" %>
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

        <title>医生信息</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <%--        <link rel="stylesheet" type="text/css" href="styles.css">--%>

        <link href="../../css/doctor_info.css" type="text/css" rel="stylesheet">


        <script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>
        <%@ include file="../../leftHead.jsp" %>
    </head>

    <body>
        <%@ include file="../../heading.jsp" %>

        <div id="doctorInfo">
            <%--侧边菜单栏--%>
            <!--侧栏界面设计-->
            <div id="mySidenav" class="sidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <a href="#">About</a>
                <br/><br/>
                <a href="/doctorHandle">医生信息</a>
                <br/><br/>
                <a href="/doctorHandle?method=RegisterHandle">挂号管理</a>
                <br/><br/>
                <a href="/doctorHandle?method=RegisterHandle">病例管理</a>
            </div>

            <div>
                <%--    <h2>侧边栏实例 - 页面主体向右移动</h2>--%>
                <%--    <p>点击以下菜单图标打开侧边栏，主体内容向右偏移。主体内容添加黑色透明背景</p>--%>
                <script>openNav()</script>
                <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; 菜单栏</span>
            </div>
            <br/>

            <div class="navigation">
                <a id="choose">当前位置:&nbsp;&nbsp;查看医生信息
                    <a href="/book?method=findAllMedicalRecord" class="a">${sessionScope.patient.name}</a>&nbsp;<a
                        href="/logout">注销</a>
                </a>
            </div>

            <div>
                <h2>基本信息</h2>
                <table class="table" cellspacing="0">
                    <tr>
                        <td>医生姓名:</td>
                        <td>${sessionScope.doctor.name}</td>
                    </tr>

                    <tr>
                        <td>医生年龄:</td>
                        <td>${sessionScope.doctor.age}</td>
                    </tr>

                    <tr>
                        <td>医生性别:</td>
                        <td>${sessionScope.doctor.sex}</td>
                    </tr>

                    <tr>
                        <td>医生职称:</td>
                        <td>${sessionScope.doctor.title}</td>
                    </tr>

                    <tr>
                        <td>医生专长:</td>
                        <td>${sessionScope.doctor.speciality}</td>
                    </tr>

                </table>

                <div class="line"></div>

                <h2>个人简介</h2>
                <p>
                    徐宝双，男，主任中医师，从事传染病治疗工作近20年，尤其在中西医结合治疗慢性乙肝阳转阴及重型肝炎、肝硬化等方面积累了丰富的临床经验，并在国家级及省级学术刊物上发表论文多篇，科研课题获市临床医疗成果奖。
                </p>
            </div>
        </div>


        <%@ include file="../../footer.jsp" %>
    </body>
</html>
