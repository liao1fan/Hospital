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
        <title>添加医生</title>
        <script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>

    </head>
    <body>
        <form action="/admin?method=addDoctor" method="post" id="SignupForm" class="signup">

            <div>
                <p>
                    医生姓名:<input type="text" name="name" >
                </p>
            </div>

            <div>
                <p>
                    医生年龄:<input type="text" name="age">
                </p>
            </div>

            <div>
                <p>
                    医生性别:<input type="text" name="sex">
                </p>
            </div>

            <div>
                <p>
                    医生职称:<input type="text" name="title">
                </p>
            </div>

            <div>
                <p>
                    医生专长:<input type="text" name="speciality">
                </p>
            </div>

            <div>
                <p>
                    医生科室:<input type="text" name="departmentName">
                </p>
            </div>

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