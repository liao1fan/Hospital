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
            <div class="navigation">
                <div class="readerBlock1">
                    当前位置:&nbsp;&nbsp;病例详细信息
                </div>

                <div class="readerBlock2">
                    欢迎回来&nbsp;: <a class="a" href="/register?method=patientCase&patientId=${sessionScope.patient.id}">${sessionScope.patient.name}</a>&nbsp;
                    <a class="a" href="/logout">注销</a>
                </div>
                </a>
            </div>

            <table cellspacing="0">
                <tr>
                    <div class="align">
                        患者姓名:<input type="text" value="${treat.patient.name}" name="patient_name" readonly/>
                    </div>
                </tr>
                <br/>

                <tr>
                    <div class="align">
                        患者性别:<input type="text" value="${treat.patient.sex}" name="patient_sex" readonly/>
                    </div>
                </tr>
                <br/>

                <tr>
                    <div class="align">
                        患者年龄:<input type="text" value="${treat.patient.age}" name="patient_age" readonly/>
                    </div>
                </tr>
                <br/>

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
                        <textarea name="drug_info" cols="150" rows="10"><c:forEach items="${drugInfoList}" var="drugInfo">${drugInfo}&#13;</c:forEach></textarea>
                    </div>
                </tr>
                <br/>
                <tr>
                    <div class="price">
                        <a class="patient1">药品总价:</a>
                        <textarea name="diagnose" id="price">${drugTotalCost}</textarea>
                    </div>
                </tr>
                <br/>
                <button class="button" onclick="location.href='/register?method=patientCase&patientId=${sessionScope.patient.id}'">返回上一页</button>
            </table>
        </div>

        <%@ include file="../../footer.jsp" %>
    </body>
</html>
