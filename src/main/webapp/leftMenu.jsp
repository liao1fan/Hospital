<%--
  Created by IntelliJ IDEA.
  User: Mus1tang
  Date: 2021/6/9
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="css/leftMenu.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
            /*打开侧栏，修改侧栏宽度，主体左跨度、背景透明度*/
            function openNav() {
                document.getElementById("mySidenav").style.width = "250px";
                // document.getElementById("main").style.marginLeft = "250px";
                document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
            }
            /*关闭侧栏，恢复原始侧栏宽度，主体左跨度、背景透明度*/
            function closeNav() {
                document.getElementById("mySidenav").style.width = "0";
                // document.getElementById("main").style.marginLeft= "0";

                document.body.style.backgroundColor = "white";
            }
        </script>
    </head>
    <body>
        <!--侧栏界面设计-->
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="#">About</a>
            <a href="#">Services</a>
            <a href="#">Clients</a>
            <a href="#">Contact</a>
        </div>

        <div id="main">
<%--            <h2>侧边栏实例 - 页面主体向右移动</h2>--%>
<%--            <p>点击以下菜单图标打开侧边栏，主体内容向右偏移。主体内容添加黑色透明背景</p>--%>
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; 菜单栏</span>
        </div>
    </body>
</html>

