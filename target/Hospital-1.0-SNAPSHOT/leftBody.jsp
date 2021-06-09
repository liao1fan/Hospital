<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--侧栏界面设计-->
<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="#">About</a>
    <br/><br/>
    <a href="#">医生信息</a>
    <br/><br/>
    <a href="#">挂号管理</a>
    <br/><br/>
    <a href="#">病例管理</a>
</div>

<div >
<%--    <h2>侧边栏实例 - 页面主体向右移动</h2>--%>
<%--    <p>点击以下菜单图标打开侧边栏，主体内容向右偏移。主体内容添加黑色透明背景</p>--%>
    <script>openNav()</script>
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; 菜单栏</span>
</div>