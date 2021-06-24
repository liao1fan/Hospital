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
        <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

        <link href="../../css/getDrug.css" type="text/css" rel="stylesheet">
        <link href="../../css/background.css" rel="stylesheet">

        <script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>


        <style>
            .qcdromodel {
                width: 500px;
            }

            .qc-dromodel {
                display: none;
            }

            ul li {
                list-style: none;
            }
        </style>


        <%@ include file="../../leftHead.jsp" %>
    </head>

    <body>
        <%@ include file="../../heading.jsp" %>

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
                <a href="/doctorHandle?method=caseHandle">病例管理</a>
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
                <div class="readerBlock1">
                    当前位置:&nbsp;&nbsp;取药
                </div>

                <div class="readerBlock2">
                    <a href="/book?method=findAllMedicalRecord" class="a">${sessionScope.patient.name}</a>&nbsp;<a
                        href="/logout" class="aa">注销</a>
                </div>
            </div>

            <div>
                <a action="/doctorHandle?method=addDrug&treatId=${treatId}" method="post">
                    <section class="navigation">

                        <div class="qcdromodel">
                            <a id="drugName">药品名称:</a>
                            <input type="text" name="drugName" id="onezs" class="qc-zsearch" onclick="onezs();" placeholder="输入药品名称">
                            <ul class="qc-dromodel" id="modedata">
                                <input type="text" id="twoxj" class="qc-search" placeholder="输入药品名称">
                                <ul class="qc-dromodel_1" id="medicine">
                                    <c:forEach items="${drugList}" var="drug">
                                        <li><a href="javascript:;" id="drug">${drug.name}</a></li>
                                    </c:forEach>
                                </ul>
                            </ul>
                        </div>
                    </section>

                    <a class="patient">药品数量:</a>
                    <select name="drugNum" id="selectNum">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                    </select>
                    <br/>
                    <input class="button" type="submit" value="确认"/>
                </a>
            </div>
                <br/>

            <div class="patient">
                <a class="patient1"> 药品信息:</a>
                <textarea name="drugInfo" cols="150" rows="20" align="center">
                <c:forEach items="${drugInfoList}" var="drugInfo">
                    ${drugInfo}
                </c:forEach>
            </textarea>
            </div>
                <br/><br/>
                <button onclick="location.href='/doctorHandle?method=getDrug&treatId=${treatId}'">继续取药</button>
                <button onclick="location.href='/doctorHandle?method=displayDiagnose&treatId=${treatId}'">返回上一页</button>
        </div>
        <%@ include file="../../footer.jsp" %>
    </body>

    <script type="text/javascript">

        $(document).ready(function () {
            //点击空白收回下拉框
            $('.wew').click(function () {
                alert(11);
                $('.qc-dromodel').hide();
            });
            //搜索条件查询
            $(".qc-search").on('input propertychange', function () {
                var searchTerm = $(this).val();
                $(this).siblings('.qc-dromodel_1').show();
                $(this).addClass('cli');
                var searchSplit = searchTerm.replace(/ /g, "'):containsi('");
                $.extend($.expr[':'], {
                    'containsi': function (elem, i, match, array) {
                        return (elem.textContent || elem.innerText || '').toLowerCase()
                            .indexOf((match[3] || "").toLowerCase()) >= 0;
                    }
                });
                $(this).siblings('.qc-dromodel_1').find('li').not(":containsi('" + searchSplit + "')").each(function () {
                    $(this).hide();
                });
                $(this).siblings('.qc-dromodel_1').find("li:containsi('" + searchSplit + "')").each(function () {
                    $(this).show();
                });
            });
            // input 输入框点击事件
            $('.qcdromodel').on('click', function (e) {
                $(".qcdromodel").find("ul").hide();// 让ul隐藏（当你一个页面多个这样的输入框时你就会用到）
                $(this).find('ul').show();// 当前子节点显示
                e.stopPropagation();// 阻止事件冒泡
            });
            // 下拉框里面内容收起
            $('.qc-dromodel li a').on('click', function (e) {
                $("#onezs").css("display", "block");
                $(this).parents('.qc-dromodel').hide().siblings('.qc-zsearch').removeClass('selected').removeClass('cli').val($(this).text());
                e.stopPropagation();// 阻止事件冒泡
            });
        });

        function onezs() {
            $("#onezs").css("display", "none");
        }

    </script>
</html>
