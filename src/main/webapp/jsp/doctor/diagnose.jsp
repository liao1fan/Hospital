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

        <link href="../../css/diagnose.css" type="text/css" rel="stylesheet">
        <link href="../../css/background.css" type="text/css" rel="stylesheet">
        <link href="../../css/menu.css" type="text/css" rel="stylesheet">

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
                    当前位置:&nbsp;&nbsp;添加诊断信息
                </div>

                <div class="readerBlock2">
                    <a class="a" href="/logout">注销</a>
                </div>
            </div>

            <table cellspacing="0">
                <tr>
                    <div class="patient">患者姓名:
                        <input type="text" value="${treat.patient.name}" name="patient_name" readonly/>
                    </div>
                </tr>
                <br/>

                <tr>
                    <div class="patient">
                        患者性别:<input type="text" value="${treat.patient.sex}" name="patient_sex" readonly/>
                    </div>
                </tr>
                <br/>

                <tr>
                    <div class="patient">
                        患者年龄:<input type="text" value="${treat.patient.age}" name="patient_age" readonly/>
                    </div>
                </tr>
                <br/>

                <form action="/doctorHandle?method=addDiagnose&treatId=${treat.id}" method="post">
                    <tr>
                        <div class="patient">
                            <a class="patient1">患者症状:</a>
                            <textarea name="symptom" cols="150" rows="10" align="center">${treat.symptom}</textarea>
                        </div>
                    </tr>
                    <br/>
                    <tr>
                        <div class="patient">
                            <a class="patient1">诊断信息:</a>
                            <textarea name="diagnose" cols="150" rows="10">${treat.diagnose}</textarea>
                        </div>
                    </tr>
                    <br/>
                    <tr>
                        <div class="patient">
                            <a class="patient1">处方信息:</a>
                            <textarea name="drug_info" cols="150" rows="10">
                                <c:forEach items="${drugInfoList}" var="drugInfo">
                                    ${drugInfo}
                                </c:forEach>
                            </textarea>
                        </div>
                    </tr>
                    <br/>
                    <tr>
                        <div class="patient">
                            <a class="patient1">药品总价:</a>
                            <p>${drugTotalCost}</p>
                        </div>
                    </tr>
                    <br/>
                    <input class="button" type="submit" value="保 存"/>

                </form>
                <button class="button"
                        onclick="location.href='/doctorHandle?method=getDrug&treatId=${treat.id}&sum=${drugTotalCost}'">
                    取 药
                </button>
                <button class="button" onclick="location.href='/doctorHandle?method=caseHandle'">返回上一页</button>
            </table>


        </div>

        <%@ include file="../../footer.jsp" %>
    </body>
</html>
