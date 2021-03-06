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

        <title>My JSP 'register.jsp' starting page</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

        <link href="../../css/index.css" type="text/css" rel="stylesheet">
        <link href="../../css/background.css" rel="stylesheet">
        <link href="../../css/readerBlock.css" rel="stylesheet">
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
                <br/><br/>
                <a href="/doctorHandle">医生信息</a>
                <br/><br/>
                <a href="/doctorHandle?method=RegisterHandle">挂号管理</a>
                <br/><br/>
                <a href="/doctorHandle?method=caseHandle">病例管理</a>
            </div>

            <div class="div_menu">
                <script>openNav()</script>
                <span class="menu" onclick="openNav()">&#9776; 菜单栏</span>
            </div>

            <div class="navigation">
                <div class="readerBlock1">
                    当前位置:&nbsp;&nbsp;处理挂号记录
                </div>

                <div class="readerBlock2">
                    <a class="a" href="/logout">注销</a>
                </div>
            </div>

            <table class="table" cellspacing="0">
                <tr>
                    <td>患者姓名</td>
                    <td>挂号时间</td>
                    <td>审核状态</td>
                    <td>操作</td>
                </tr>


                <c:forEach items="${registerList}" var="register">
                    <tr>
                        <td>${register.patient.name}</td>
                        <td>${register.date}</td>
                        <td>
                            <c:if test="${register.state == 0}">
                                <font color="#9acd32">未确认</font>
                            </c:if>
                            <c:if test="${register.state == 1}">
                                <font color="blue">已确认</font>
                            </c:if>
                            <c:if test="${register.state == 2}">
                                <font color="red">未通过</font>
                            </c:if>
                        </td>
                        <td>
                            <a href="/doctorHandle?method=handle&registerId=${register.id}&state=1&page=1">确认</a>&nbsp;
                            <a href="/doctorHandle?method=handle&registerId=${register.id}&state=2&page=1">不予通过</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <%@ include file="../../footer.jsp" %>
    </body>
</html>
