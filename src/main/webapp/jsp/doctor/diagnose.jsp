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
        <%--        <link rel="stylesheet" type="text/css" href="styles.css">--%>

        <link href="../../css/index.css" type="text/css" rel="stylesheet">
        <%--        <link href="../../css/background.css" type="text/css" rel="stylesheet">--%>
        <link href="../../css/heading.css" type="text/css" rel="stylesheet">

        <script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>
        <%@ include file="../../leftHead.jsp" %>
    </head>

    <body>
        <%@ include file="../../top.jsp" %>

        <div id="main">
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
            <%-- 侧边栏end  --%>
            <br/>
            <div class="navigation">
                当前位置:&nbsp;&nbsp;添加诊断信息
                <a href="/book?method=findAllMedicalRecord">${sessionScope.patient.name}</a>&nbsp;<a
                    href="/logout">注销</a>
            </div>

            <table class="table" cellspacing="0">
                <tr>患者姓名:<input type="text" value="${treat.patient.name}" name="patient_name" readonly/></tr>
                <br/><br/>

                <tr>患者性别:<input type="text" value="${treat.patient.sex}" name="patient_sex" readonly/></tr>
                <br/><br/>
                <tr>患者年龄:<input type="text" value="${treat.patient.age}" name="patient_age" readonly/></tr>
                <br/><br/>
                <form action="/doctorHandle?method=addDiagnose&treatId=${treat.id}" method="post">
                    <tr>
                        患者症状:<textarea name="symptom" cols="150" rows="10" align="center">${treat.symptom}</textarea>
                    </tr>
                    <br/><br/>
                    <tr>
                        诊断信息:<textarea name="diagnose" cols="150" rows="20" align="center">${treat.diagnose}</textarea>
                    </tr>
                    <br/><br/>
                    <tr>
                        处方信息:<textarea name="drug_info" cols="150" rows="10" align="center">
                            <c:forEach items="${drugInfoList}" var="drugInfo">
                                ${drugInfo}
                            </c:forEach>
                    </textarea>
                    </tr>
                    <br/><br/>

                    <input type="submit" value="保 存"/>
                </form>
                <button onclick="location.href='/doctorHandle?method=getDrug&treatId=${treat.id}'">取 药</button>

            </table>


        </div>

        <%@ include file="../../footer.jsp" %>
    </body>
</html>
