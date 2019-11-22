<%--
  Created by IntelliJ IDEA.
  User: 17646
  Date: 2019/7/7
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--使用标签库--%>


<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <title>猫咪网站后台管理系统</title>
        <link href="css/Backgroud_Management_System.css" rel="stylesheet" type="text/css" />
</head>
    <body>

    <div class="top" style="width: 1500px;height: 88px;background: #bce0f5;text-align: center;margin-bottom: 35px">
        <div style="padding-top: 28px; font-size: 21px"><span>猫咪网站后台管理系统</span></div>
    </div>
    <div style="text-align: center;margin-bottom: 50px;width: 1500px">

        <button onclick="window.location.href='AddProduct.jsp'" style="width: 120px;height: 59px;font-size: 19px;">添加商品</button>
        <button onclick="window.location.href='DeleteProduct.jsp'" style="width: 120px;height: 59px;font-size: 19px;">删除商品</button>
    </div>
    <div class="container" style="border: #5d5d5d 1px solid;text-align: center;width: 1300px; margin-left: 100px">
        <div class="bt" style="height: 50px; width: 1300px">
            <ul class="order-title">
                <li class="pid" style="width: 150px">商品编号</li>
                <li class="cid" style="width: 150px">商品分类</li>
                <li class="pname" style="width: 150px">商品名称</li>
                <li class="price-one" style="width: 150px">商品单价</li>
                <li class="product-img" style="width: 150px">商品图片</li>
                <li class="product-desc" style="width: 150px">商品信息</li>
                <li class="operate" style="width: 150px">操作</li>
            </ul>
        </div>
<%--<c:forEach items="${productList}" var="pro">--%>
    <c:forEach items="${adminproducts}" var="pro">
        <div class="" style="width: 100%;height: 70px;border: #747f80 1px solid;">
        <ul class="products" style="margin-top: 0px ;height: 70px">
            <li class="pid1" style="width: 150px" >${pro.pid}</li>
            <li class="cid1" style="width: 150px">${pro.cid}</li>
            <li class="pname1" style="width: 150px">${pro.pname}</li>
            <li class="price-one" style="width: 150px">${pro.price}</li>
            <li class="product-img" style="width: 150px; height: 50px"><img src="${pro.imgurl}" style="height: 60px; width: 70px" /></li>
            <li class="product-desc" style="width: 150px"><span class="desc"> ${pro.pdesc}</span></li>
            <li class="operate" style="width: 150px">
                <%--<a class="update" href="">[编辑]</a>--%>
                <input type="button" name="edit" value="编辑" onclick="window.location.href='ProductServlet.do?key=4&pid=${pro.pid}'">
                <span > | </span>
                <%--onClick="return confirm('确定删除?');"--%>
                <%--<a class="delete" href="javascript:;" onclick="commit(${pro.pid}, this)" >[删除]</a>--%>
                <input type="button" name="delete" value="删除" onclick="commit(${pro.pid},this)">
            </li>
        </ul>
        </div>
    </c:forEach>
    </div>

    </body>
<script src="js/jquery_2.1.4_baidu_min.js"></script>
<script>
    function commit(pid, obj) {
        if(confirm("确认删除编号为"+pid+"的商品吗？")){
            ajax_delete(pid, obj);
        }
    }
    function ajax_delete(pid, obj) {
        // alert(pid);
        $.ajax({
            url:"ProductServlet.do",
            type:"post",
            datatype:"json",
            data:{
                key:2,
                pid:pid
            },
            success:function (data) {
                    alert("删除成功！");
                    var tr = obj.parentNode.parentNode;
                    var tbody=tr.parentNode;
                    tbody.remove(tr);
            }
        });
    }
</script>
</html>
