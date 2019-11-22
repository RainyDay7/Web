<%--
  Created by IntelliJ IDEA.
  User: 17646
  Date: 2019/7/3
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--使用标签库--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品首页</title>
    <link href="css/List_of_Goods.css" rel="stylesheet" type="text/css" />
    <style>

    </style>
</head>

<body style="background:#f9eae7">
<div class="whole">
    <div class="top" style="background: url('img/kuang.jpg');" >
        <div class="top-huanying" > </div>
    </div>

    <div   style="">
        <c:forEach items="${productList}" var="pro">
            <div class="back1">
                <div class="picture" style ="">
                    <a  href="ProductDetailsServlet.do?pid=${pro.pid}" title="${pro.pname}" target="_blank" >
                        <img src="${pro.imgurl}"   alt="${pro.pname}"  style="width: 200px; height: 200px">
                    </a>
                </div>
                <div class="introduction">
                    <a class="introduction-1" href="ProductDetailsServlet.do?pid=${pro.pid}" title="Here is the introduction of commodities. " target="_blank" >
                        <br>${pro.pname}<br>
                        price:${pro.price}元<br>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="bottom" style="background: url('img/kuang.jpg');">
    </div>
</div>
</body>
</html>
