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
    <link rel="stylesheet" href="../../css/signup1.css">
    <head>
        <title>登录</title>
        <script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>
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
        <form action="/signup" method="post" id="SignupForm" class="signup">
            
            <div>
                <p>
                    用户名:<input type="text" name="username">
                </p>
            </div>

            <div>
                <p>
                    密码:<input type="password" name="password">
                </p>
            </div>

            <div>
                <p>
                    姓名:<input type="text" name="name">
                </p>
            </div>

            <div>
                <p>性别:
                    <select id="Patient_sex" name="sex">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </p>
            </div>

            <div>
                <p>
                    年龄:<input type="text" name="age">
                </p>
            </div>

            <div>
                <p>
                    地址:<input type="text" name="address">
                </p>
            </div>

            <div>
                <p>
                    联系电话:<input type="text" name="phone" id="phone">
                </p>
            </div>


            <input type="submit" value="提交" id="submit">
        </form>
    </body>
</html>

<div id="footer">
    <div class="foot_content">
        CopyRight &copy; 2021 www.cau.edu.cn 中国农业大学
    </div>
    <div class="foot_content">
        版权所有 Hospital V1.0
    </div>
</div>