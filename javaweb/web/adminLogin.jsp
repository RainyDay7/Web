<%--
  Created by IntelliJ IDEA.
  User: 17646
  Date: 2019/7/4
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员登录</title>
    <link type="text/css" href="css/adminLogin.css" rel="stylesheet">
</head>
<body style="background: url('img/1.jpg');background-repeat:no-repeat;background-size:cover;   ">
<div id="admin_box" style="border: #eee solid 3px; opacity:0.7">
    <div id="Member_join">管理员登录</div>
    <div id="regForm" style="text-align: center">
        <form action="AdminLoginServlet.do?key=3" method="post">
            <span class="span1">用户名：</span>
            <input class="input1" tabindex="1" type="text" onblur="cheackusername()" name="adminame" id="adminame" placeholder="请输入管理员名 " autocomplete="off">
            <br>
            <span class="span1"> 密　码：</span>
            <input class="input1" tabindex="2" type="password" onblur="cheackpassword()" name="password" id="password" placeholder="请输入密码" autocomplete="new-password">
            <br>
            <input class="input2" type="submit" value="登&nbsp;&nbsp;&nbsp;录" style="background:#fd871d;color: white; font-size: 20px; border: 0px;outline:none;cursor: pointer;"/>
        </form>
    </div>
</div>

</body>
</html>