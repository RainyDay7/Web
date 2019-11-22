<%--
  Created by IntelliJ IDEA.
  User: 17646
  Date: 2019/7/5
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品详情</title>
    <link href="css/Goods_Details.css" rel="stylesheet" type="text/css" />
</head>
<body style="width: 1500px;">
<div class="top" style="background: url('img/top.jpg');">
</div>
<div class="shop-top" >
    <ul class="box" style=" margin-left: 200px">
        <li> <a href="index.jsp" >首页 </a> </li>
        <li> <a href="" >猫猫1</a> </li>
        <li> <a href="" >猫猫2</a> </li>
        <li> <a href="" >猫猫3</a> </li>
        <li> <a href="" >猫猫4</a> </li>
        <li> <a href="/ShoppingCartLoginServlet.do?key=2" >购物车</a> </li>
    </ul>
</div>

<div>
    <div class="big-box" >

        <div class="image-title" >
            <div class="big-img" >
                <button class="middle">
                    <img src="${imgurl}" style="width: 350px; height: 400px">
                </button>
            </div>
            <div class="info-box">
                <h2 class="goods-title">
                    <span class="tag"></span>
                    <span class="title-small" itemprop="name">${pname}</span>
                </h2>
                <span class="desc" style="display: block">${pdesc}</span>
                <div class="goods-price" style="background: #f6f6f6">
                    <div class="price">
                        <dl >
                            <dd class="price-now">
                                <span class="p1">价格：&nbsp;</span>
                                <span class="p2">${price}</span>
                            </dd>
                        </dl>
                        <dl>
                            <dd class="pj">
                                <span class="pj-hz">评价：&nbsp;</span>
                                <span class="pj-num">890</span>
                            </dd>
                            <dd class="xl">
                                <span class="xl-hz">销量：&nbsp;</span>
                                <span class="xl-num">3750</span>
                            </dd>
                        </dl>
                    </div>
                </div>
                <br>
                <%--<div>--%>
                    <%--&lt;%&ndash;<form name="buy" action=""  method="post">&ndash;%&gt;--%>
                        <%--数量：--%>
                        <%--<input class="input1"type="button" name="minus" value="-"  onclick="minus();" style="width: 40px;height: 28px">--%>
                        <%--<input class="input1"type="text" name="amount" value="1" class="kuang" style="width: 80px;height: 24px">--%>
                        <%--<input class="input1"type="button" name="plus" value="+" onclick="plus();"style="width: 40px;height: 28px"><br>--%>
                        <%--<button name="buyNow" conclick="buyNow();" style=" width: 200px;height: 50px;background-color: #ef6b66;color: white; font-size: 26px;margin-top: 28px;">立即购买</button>--%>
                        <%--<button name="buyLater" onclick="buyLater();" style=" width: 200px;height: 50px;margin-left: 20px; text-align: center;border:1px solid #5d5d5d;font-size: 26px;margin-top: 28px;background-color: white">加入购物车</button>--%>
                    <%--&lt;%&ndash;</form>&ndash;%&gt;--%>
                <%--</div>--%>
                <div>
                    <form name="buy" action="/ShoppingCartLoginServlet.do?key=1&pid=${pid}"  method="post">
                    数量：
                    <input class="input1"type="number" name="amount" value="1" class="kuang" style="width: 80px;height: 24px"><br>
                    <input type="button" name="buyNow" value="立即购买"onclick="buyNow();" style=" width: 200px;height: 50px;background-color: #ef6b66;color: white; font-size: 26px;margin-top: 28px;"></input>
                    <input type="submit"  value="加入购物车"style=" width: 200px;height: 50px;margin-left: 20px; text-align: center;border:1px solid #5d5d5d;font-size: 26px;margin-top: 28px;background-color: white"></input>
                    </form>
                </div>
            </div>
        </div>
        <div class="small-img" >
            <ul class="list" style="text-align: center;">
                <li><img class="m" src="img/m1.jpg" style=" border: black 1px solid"></li>
                <li><img class="m" src="img/m4.jpg" style= "border: black 1px solid"></li>
                <li><img class="m" src="img/m5.jpg" style=" border: black 1px solid"></li>
                <li><img class="m" src="img/m3.jpg" style=" border: black 1px solid"></li>
            </ul>
        </div>
    </div>
    <div class="bottom" style="background: url('img/kuang.jpg');">
    </div>
</div>
<script>
    function minus() {
        var amounts=document.getElementsByName("amount");
        var count=amounts[0].value;
        if(count<=1) amounts[0].value=1;
        else {amounts[0].value-=1;}
    }
    function plus() {
       // alert(1);
      var amounts=document.getElementsByName("amount");//返回的是一个集合
        var count=amounts[0].value;
        amounts[0].value = parseInt(count)+1;//转换的作用是防止+号进行字符串拼接
    }
    function buyNow() {
        alert(11);
        var count=document.getElementsByName(buyNow);
        document.buy.action="/ShoppingCartLoginServlet.do?key=1&amount=count";
        document.buy.submit();
    }
    function buyLater() {
        alert(12);
        document.buy.action="/ShoppingCartLoginServlet.do?key=1&pid=${pid}";
        document.buy.submit();
    }
</script>
</body>
</html>
