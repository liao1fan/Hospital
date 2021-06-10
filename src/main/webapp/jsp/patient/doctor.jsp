<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        aaaaaa
        <base href="<%=basePath%>">

        <title>My JSP 'register.jsp' starting page</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <%--        <link rel="stylesheet" type="text/css" href="styles.css">--%>

        <link href="../../css/index.css" type="text/css" rel="stylesheet">

        <script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>

    </head>

    <body>
        <%@ include file="../../top.jsp" %>

        <div id="main">
            <div class="navigation">
                当前位置:&nbsp;&nbsp;<a href="/register">选择科室</a>->选择日期和医生
                <div id="readerBlock">欢迎回来&nbsp;:
                    <a href="/book?method=findAllMedicalRecord">${sessionScope.patient.name}</a>&nbsp;<a href="/logout">注销</a>
                </div>
            </div>
            <div class="img_block">
                <img src="../../images/main_booksort.gif" class="img"/>
            </div>

            <h2>选择日期和医生</h2><br/>

            <select id="state" onchange="self.location.href=options[selectedIndex].value">
                <c:forEach items="${doctorStateList}" var="state">
                    <c:choose>
                        <c:when test="${state.date == stateDateDefault}">
                            <option value="/register?method=updateState&id=${state.date}&departmentId=${departmentId}"
                                    selected="selected">${state.date}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="/register?method=updateState&id=${state.date}&departmentId=${departmentId}">${state.date}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

            </select>

            <table class="table" cellspacing="0">
                <tr>
                    <td>医生姓名</td>
                    <td>医生职称</td>
                    <td>医生专长</td>
                    <td>号码剩余</td>
                    <td>挂号费用</td>
                    <td>日期</td>
                    <td>操作</td>
                </tr>

                <c:forEach items="${doctorStateDefault}" var="doctorState">
                    <tr>
                        <td>${doctorState.doctor.name}</td>
                        <td>${doctorState.doctor.title}</td>
                        <td>${doctorState.doctor.speciality}</td>
                        <td>${doctorState.num}</td>
                        <td>${doctorState.fee}</td>
                        <td>${doctorState.date}</td>
                        <td>
                            <a href="/register?method=displayCurrentDoctor&doctorStateId=${doctorState.id}&departmentId=${departmentId}">挂号</a>
                        </td>
                    </tr>
                </c:forEach>


            </table>
<%--            <hr class="hr"/>--%>
<%--            <div id="pageControl">--%>
<%--                <div class="pageControl_item">每页<font id="dataPrePage">${dataPrePage }</font>条数据</div>--%>
<%--                <div class="pageControl_item" id="last">最后一页</div>--%>
<%--                <div class="pageControl_item" id="next">下一页</div>--%>
<%--                <div class="pageControl_item"><font id="currentPage">${currentPage }</font>/<font--%>
<%--                        id="pages">${pages }</font></div>--%>
<%--                <div class="pageControl_item" id="previous">上一页</div>--%>
<%--                <div class="pageControl_item" id="first">首页</div>--%>
<%--            </div>--%>
        </div>

        <%@ include file="../../footer.jsp" %>
    </body>
</html>
