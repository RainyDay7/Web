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
    <title>删除商品</title>
    <link type="text/css" href="css/DeleteProduct.css" rel="stylesheet">
</head>
<body style="background: url('img/1.jpg');background-repeat:no-repeat;background-size:cover;  " >
<div id="admin_box" style="border: #eee solid 3px; opacity:0.8;">
    <div id="Member_join">删除商品</div>
    <div id="regForm" style="text-align: center">
        <form action="ProductServlet.do?key=2" method="post">
            <span class="span1">商品pid：</span>
            <input class="input1" tabindex="1" type="text" onblur="cheackpid()" name="pid" id="pid" placeholder="请输入pid " autocomplete="off">
            <br>
            <input class="input2" type="submit" value="确&nbsp;&nbsp;&nbsp;定" style="background:#fd871d;color: white; font-size: 20px; border: 0px;outline:none;cursor: pointer;"/>
        </form>
    </div>
</div>

</body>
</html>