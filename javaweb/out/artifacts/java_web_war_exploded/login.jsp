<%--
  Created by IntelliJ IDEA.
  User: 17646
  Date: 2019/7/3
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="top" style="height: 85px; background: url('img_db/heng2.jpg');width: 1500px;">
    <div class="top-left"><img class="top-left-img" src="img/cicle1.png"></div>
    <div class="shop-top-left" >
        <ul class="box" style="">

            <li> <a  href=""class="l1" >首页 </a> </li>
            <li> <a href="" class="l1">买猫选猫</a> </li>
            <li> <a href="" class="l1">猫咪资讯</a> </li>
            <li> <a href="" class="l1">选猫知识</a> </li>
            <li> <a href="" class="l1">猫咪品种</a> </li>
        </ul>
    </div>
    <div class="shop-top-right" >
        <ul class="box" style=" margin-left: 200px">
            <li> <a href="/ProductServlet.do?key=3" class="l2">首页 </a> </li>
            <li> <a href="" class="l2">加入我们</a> </li>
            <li> <a href="" class="l2">联系我们</a> </li>
            <li> <a href="" class="l2">关于我们</a> </li>
            <li> <a href="" class="l2">发布信息</a> </li>
        </ul>
    </div>
</div>

<div  class="login-top" style=" background: #79c2ed; height: 375px;width: 1500px;" >
    <div class="left">
        <!--登录页面-->
        <div class="left-img">
            <img src="img/t.jpg" >
        </div>
    </div>
    <div class="cneter">
        <div class="center-table">
            <form action="login.do?key=1" method="post" style="margin-top: 30px">
                <span class="zhanghu">帐户登录</span><br>
                <span><b>用户</b></span>
                <input class="input1" type="text" name="username" value="admin"  placeholder="请输入用户名" /><br>
                <span><b>密码</b></span>
                <input class="input1" type="password" name="password" value="admin" placeholder="请输入密码" /> <br>
                <input class="input1" type="submit" value="登&nbsp;&nbsp;&nbsp;录" style="margin-left:52px "/>
            </form>

        </div>
        <div class="tzzc">
            <span>没有账号？去</span>
            <a href="add.jsp" >注册</a>
        </div>
    </div>
    <div class="right">
        <div class="right-img">
            <img src="img/tom1.jpg">
        </div>
    </div>


</div>
<div class="jieshao" style="width: 100%">
    <div class="jieshao1" style="width: 80%; margin-left:10%">
        <div class="i">
            <div class="js-img">
                <img src="img/label1.jpg" style="margin: 20px">
            </div>
            <div class="t"><span>百分百纯种</span></div>
        </div>

        <div class="i">
            <div class="js-img">
                <img src="img/lable2.jpg" style="margin: 20px">
            </div>
            <div class="t"><span>30天质保</span></div>
        </div>

        <div class="i">
            <div class="js-img">
                <img src="img/label3.jpg" style="margin: 20px">
            </div>
            <div class="t"><span>养宠顾问</span></div>
        </div>

        <div class="i">
            <div class="js-img">
                <img src="img/label4.jpg"style="margin: 20px">
            </div>
            <div class="t"><span>终身售后</span></div>
            </div >
        </div>
    </div>
</div>
</body>
</html>
