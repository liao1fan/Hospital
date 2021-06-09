<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<%--<link rel="icon" href="images/search.gif" type="img/x-ico" />--%>
<link href="css/login2.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>
<body>
	<div id="top"></div> 
	<div id="main">
		<img src="images/login.jpg" id="main_bg"/>
		<div id="login_block">
			<form action="/login" method="post" id="loginForm">
				<table border="0">
					<tr>
						<td class="title">用户名:</td>
						<td class="input">
							<input type="text" name="username" id="username" class="login_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">密码:</td>
						<td class="input">
							<input type="password" name="password" id="password" class="login_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">用户类型:</td>
						<td class="input">
							<input type="radio" name="type" value="patient" checked="checked"/>&nbsp;&nbsp;患者&nbsp;&nbsp;
							<input type="radio" name="type" value="doctor"/>&nbsp;&nbsp;医生
							<input type="radio" name="type" value="admin"/>&nbsp;&nbsp;管理员
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input class="btn" name="logintype"  type="submit" value="登录"/>
							<input class="btn" name="logintype"  type="submit" value="注册"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="footer">
		<div class="foot_content">
			CopyRight &copy; 2020 www.cau.edu.cn 中国农业大学
		</div>
		<div class="foot_content">
			版权所有 Hospital V1.0
		</div>
	</div>
</body>
</html>