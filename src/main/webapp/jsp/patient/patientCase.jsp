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

            <div class="navigation">
                <div class="readerBlock1">
                    当前位置:&nbsp;&nbsp;查看病例信息
                </div>

                <div class="readerBlock2">
                    欢迎回来&nbsp;: <a class="a" href="/register?method=patientCase&patientId=${sessionScope.patient.id}">${sessionScope.patient.name}</a>&nbsp;
                    <a class="a" href="/logout">注销</a>
                </div>
                </a>
            </div>
            <div>
                <table class="table" cellspacing="0">
                    <tr>
                        <td>医生姓名</td>
                        <td>看病时间</td>
                        <td>诊断信息</td>
                        <td>查看详细信息</td>
                    </tr>


                    <c:forEach items="${treatList}" var="treat">
                        <tr>
                            <td>${treat.doctor.name}</td>
                            <td>${treat.time}</td>
                            <td>${treat.diagnose}</td>
                            <td>
                                <a href="/register?method=patientDiagnose&treatId=${treat.id}">查看</a>&nbsp;
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>


        <%@ include file="../../footer.jsp" %>
    </body>
</html>
