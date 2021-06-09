<%--
  Created by IntelliJ IDEA.
  User: Mus1tang
  Date: 2021/6/6
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>

<%--患者用户点击注册按钮后来到注册页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Title</title>
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
            $(function () {
                var state = ${requestScope.SignupState};
                if(state == 1) { // 用户名已存在
                    alert("用户名已存在，请使用其他用户名!");
                } else {
                    alert("注册成功");
                    $(location).attr('href', 'login1.jsp');
                }
            });
        </script>
    </head>
    <body>
        <form action="/signup" method="post" id="SignupForm">
            用户名:<input type="text" name="username" id="username"/><br/>
            密码:<input type="password" name="password" id="password"/><br/>
            姓名:<input type="text" name="name" id="name"/><br/>
            年龄:<input type="text" name="age" id="age"/><br/>
            性别:<select id="Patient_sex" name="sex">
            <option value="男">男</option>
            <option value="女">女</option>
        </select><br/>
            地址:<input type="text" name="address" id="address"/><br/>
            联系电话:<input type="text" name="phone" id="phone"/><br/>
            <input type="submit" value="提交"/>
        </form>
    </body>
</html>
