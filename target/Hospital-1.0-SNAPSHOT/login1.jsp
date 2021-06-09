<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="css/login1.css">
<%--    <script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>--%>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var state = ${requestScope.stateUser};
            if(state == "1") {
                alert("用户名不存在!");
            } else {
                if(state == "2"){
                    alert("密码错误");
                }
            }
            $(location).attr('href', 'login1.jsp');
        });
    </script>
</head>
<body>
    <form action="/login" method="post" class="login">
        <p>登录</p>
        <input type="text" placeholder="用户名" name="username">  <!--用户名输入框-->
        <input type="password" placeholder="密码" name="password"> <!--密码名输入框-->
        <input type="radio" name="type" value="patient" checked="checked" class="radio"> <!--患者按钮-->
        <label for="">患者</label>
        <input type="radio" name="type" value="doctor" class="radio"> <!--医生按钮-->
        <label for="">医生</label>
        <input type="radio" name="type" value="admin" class="radio"> <!--管理员按钮-->
        <label for="">管理员</label>
        <input type="submit" class="btn" value="登录" name="logintype"> <!--登录按钮-->
        <input type="submit" class="btn" value="注册" name="logintype"> <!--注册按钮-->
    </form>

    <div id="footer">
		<div class="foot_content">
			CopyRight &copy; 2021 www.cau.edu.cn 中国农业大学
		</div>
		<div class="foot_content">
			版权所有 Hospital V1.0
		</div>
	</div>
</body>
</html>