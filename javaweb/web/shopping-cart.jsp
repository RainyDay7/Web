<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <link href="css/shopping_cart.css" rel="stylesheet" type="text/css" />
</head>
<body class="shopping_cart"  style="background: #f9eae7">
<div class="site-naw" style="border-bottom: #f2f2f2">
    <!--顶部导航-->
    <div id="top-container" style="border-bottom: 1px black solid; width: 1500px">
        <div class="container">
            <ul class="top-left">
                <li class="top-1" style="width: 70px">
                    <a href="index.jsp" target="_blank">首页</a>
                </li>
                <li class="top-1">
                    <a href="" target="_blank">username</a>
                </li>
                <li class="top-1">
                    <a href="">退出</a>
                </li>
            </ul>
            <ul class="top-right">
                <li class="top-3">|</li>
                <li class="top-2"><a href="" >订单查询</a></li>
                <li class="top-3">|</li>
                <li class="top-2"><a href="">客户服务</a> </li>
                <li class="top-3">|</li>
                <li class="top-2"><a href="">购物车</a> </li>
                <li class="top-3">|</li>
                <li class="top-2" style="width: 130px">买猫咪的猫咪网站</li>
            </ul>
        </div>
    </div>
    <!--头部导航-->
    <div class="t1" style="width:1400px;">
        <div class="biaoti-text">
            <h1><a ><span class="bt">maomi.com猫咪网站</span></a></h1>
        </div>
        <div>
            <h1><a ><span class="kefu">在线客服</span></a></h1>
        </div>
    </div>
    <div class="container1" style="margin-left: 120px">
        <!--订单列表-->
        <div class="cart-panel" style="height: 50px; width: 1300px">
            <ul class="order-title" style="width: 1300px; height: 50px; padding: 0px">
                <li ><input id="all" tabindex="7" onclick="selectall()" type="checkbox" class="quan" style="width: 15px;height: 15px;cursor: pointer;margin-left: 30px" /></li>
                <li class="product-img" style="width: 150px; margin-left: 25px">商品图片</li>
                <li class="product-desc" style="width: 277px">商品信息</li>
                <li class="price-one" style="width: 165px">单价</li>
                <li class="num" style="width: 150px">数量</li>
                <li class="num" style="width: 150px">小计</li>
                <li class="operate" style="width: 150px; margin-left: 25px">操作</li>
            </ul>
        </div>

        <div class="bd" style="width: 1300px; ">
            <c:forEach items="${shoppingCarts}" var="pro" varStatus="sta">
                <input type="hidden" value="${pro.pid}" name="pid">
            <div>
            <ul>
                <input onclick="computeAll()"  tabindex="7" class="check-box"type="checkbox" class="quan" value="1" name="clause" style="width: 15px;height: 15px;cursor: pointer;">
                <li style="margin-left: 35px ;width: 135px;text-align: center"><img src="${pro.imgurl}" class="img" style="width: 70px;height:70px"></li>
                <li style=" width: 290px; text-align: center">${pro.pname}</li>
                <li>¥<input type="text" name="price" value="${pro.price}" class="kuang" style="width: 100px"> </li>
                <li style="width: 140px; margin-left:40px">
                    <input type="button" name="minus" value="-" onclick="minus(${sta.index});">
                    <input type="text" name="amount" value="${pro.count}" class="kuang">
                    <input type="button" name="plus" value="+" onclick="plus(${sta.index});">
                </li>
                <li  style="width: 130px;text-align: center" id="price${sta.index}" class="prione" >${pro.price}</li>
                <li style=" text-align: center;width: 180px;"><p  onclick="collection();">移入收藏</p><a href="ShoppingCartLoginServlet.do?key=3&pid=${pro.pid}">删除</a></li>
                </ul>
            </div>
            </c:forEach>
            <ol>
                <li id="totalPrice">商品总计：<span id="ttprice"></span></li>
                <li >
                <button class="btn" type="button" id="jiesuan">去结算</button></li>
            </ol>
        </div>
    </div>
</div>
<script src="js/jquery_2.1.4_baidu_min.js"></script>
<script>
    function minus(num) {
        var amounts=document.getElementsByName("amount");
        var pids=document.getElementsByName("pid");
        var count=amounts[num].value;
        if(count<=1) amounts[num].value=1;
        else {amounts[num].value-=1;}
        oneCount(num);
        computeAll();
        ajaxUpdateCar(amounts[num].value,pids[num].value);
    }
    function plus(num) {
        var amounts=document.getElementsByName("amount");
        var count=amounts[num].value;
        amounts[num].value = parseInt(count)+1;//转换的作用是防止+号进行字符串拼接
        var pids = document.getElementsByName("pid")

        oneCount(num);
        computeAll();
        ajaxUpdateCar(amounts[num].value,pids[num].value);
    }
    function oneCount(num) {
        var prices = document.getElementsByName("price");
        var price = prices[num].value;
        var amounts = document.getElementsByName("amount");
        var count=amounts[num].value;
        var sum = price*count;
        sum=sum.toFixed(2);
        var id = "price"+num;
        document.getElementById(id).innerHTML= sum;
    }
    function computeAll() {
        var pris = document.getElementsByClassName("prione");//prione是每件商品的总价
        var sum=0;
        var check=document.getElementsByName("clause");
        for(var i=0;i<pris.length;i++){
            if(check[i].checked==true){
                sum += parseFloat(pris[i].innerHTML);
            }
        }
        document.getElementById("ttprice").innerHTML = sum;
    }
    //双标签一般是innerhtml 单标签value
    function selectall() {
        // alert(1);
        var check = document.getElementsByName("clause");
        var all = document.getElementById("all");
        if(all.checked){
            // alert(all.checked);alert(check.length);
            for(var i=0; i<check.length; i++){
                if(check[i].checked == false)
                    check[i].checked =true;
            }
        }
        else{
            for(var i=0; i<check.length; i++){
                if(check[i].checked ==true)
                    check[i].checked =false;
            }
        }
        computeAll();
    }
</script>
<script>
    function ajaxUpdateCar(count, pid) {
        // alert(count);alert(pid);
        $.ajax({
            url:"ShoppingCartLoginServlet.do",
            type:"post",
            datatype:"json",
            data:{
                key:4,
                count:count,
                pid:pid
            },
            success:function (data) {
        }
        });
    }
</script>
</body>
</html>