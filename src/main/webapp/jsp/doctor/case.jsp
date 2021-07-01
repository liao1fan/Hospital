<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.example.entity.Doctor" %>
<%@ page import="com.example.entity.Treat" %>
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

        <title>My JSP 'register.jsp' starting page</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <%--        <link rel="stylesheet" type="text/css" href="styles.css">--%>

        <link href="../../css/case.css" type="text/css" rel="stylesheet">
        <link href="../../css/background.css" rel="stylesheet">
        <link href="../../css/menu.css" rel="stylesheet">

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
                <a href="/doctorHandle">医生信息</a>
                <br/><br/>
                <a href="/doctorHandle?method=RegisterHandle">挂号管理</a>
                <br/><br/>
                <a href="/doctorHandle?method=caseHandle">病例管理</a>
            </div>

            <div class="div_menu">
                <%--    <h2>侧边栏实例 - 页面主体向右移动</h2>--%>
                <%--    <p>点击以下菜单图标打开侧边栏，主体内容向右偏移。主体内容添加黑色透明背景</p>--%>
                <script>openNav()</script>
                <span class="menu" onclick="openNav()">&#9776; 菜单栏</span>
            </div>


            <div class="navigation">
                <div class="readerBlock1">
                    当前位置:&nbsp;&nbsp;查看病例信息
                </div>

                <div class="readerBlock2">
                    <a class="a" href="/logout">注销</a>
                </div>

            </div>
            <div>
                <table class="table" cellspacing="0">
                    <tr>
                        <td>患者姓名</td>
                        <td>看病时间</td>
                        <td>诊断信息</td>
                        <td>操作</td>
                    </tr>


                    <c:forEach items="${treatList}" var="treat">
                        <tr>
                            <td>${treat.patient.name}</td>
                            <td>${treat.time}</td>
                            <td>${treat.diagnose}</td>
                            <td>
                                <a href="/doctorHandle?method=displayDiagnose&treatId=${treat.id}&page=1">编辑</a>&nbsp;
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>


        <%@ include file="../../footer.jsp" %>
    </body>
</html>
