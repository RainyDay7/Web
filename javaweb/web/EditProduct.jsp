<%--
  Created by IntelliJ IDEA.
  User: 17646
  Date: 2019/7/3
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--使用标签库--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8”>
    <meta charset="UTF-8">
    <title>编辑商品</title>
    <link type="text/css" href="css/AddProduct.css" rel="stylesheet">
</head>
<body style="background: url('img/1.jpg');background-repeat:no-repeat;background-size:cover;   ">
<div id="join_box" style="border: #eee solid 3px;opacity:0.8;">
    <div id="Member_join">编辑商品</div>
    <div id="regForm" style="text-align: center">
        <form id="imm" action="/ProductServlet.do?key=5&pid=${pro.pid}" method="post" >
            <span class="span1">商品名称：</span>
            <input class="input1" value="${pro.pname}" tabindex="1" type="text" onblur="cheackpname()" name="pname" id="pname" placeholder="请输入商品名称 ，3~12字" autocomplete="off">
            <br>
            <span class="span1">商品单价：</span>
            <input class="input1" value="${pro.price}" tabindex="2" type="text" onblur="cheackprice()" name="price" id="price" placeholder="请输入商品单价，字母开头6~16字" autocomplete="off" style="margin-bottom: 20px">
            <br>
            <span class="span1" style="margin-right: 20px">商品图片：</span>
            <img id="img" src="${pro.imgurl}" width="100px" height="100px" style="margin-right: 20px; border: 3px pink solid"><!-- 显示图片的 -->
            <input name="fileImage" type="file" onchange="uploadImage();" style="width: 195px">
            <input type="hidden" name="path" id="pic" value="${pro.imgurl}">
            <%--<input class="input1" tabindex="3" type="text" onblur="cheackimg()" name="imgurl" id="imgurl" placeholder="请输入图片路径" autocomplete="off">--%>
            <br>
            <span class="span1">商品描述：</span>
            <input class="input1" value="${pro.pdesc}" tabindex="5" type="text" onblur="checkdesc()" name="pdesc" id="pdesc" placeholder="请输入商品描述" autocomplete="off">
            <br>
            <span class="span1">商品类别：</span>
            <%--<input class="input1" tabindex="4" type="text" onblur="cheackcid()" name="cid" id="cid" placeholder="请输入商品类别" autocomplete="off" >--%>
            <select  class ="input1" name="cid" id="">
                <c:forEach items="${categories}" var="cate" varStatus="sta">
                    <option value="${cate.cid}">${cate.cname}</option>
                </c:forEach>
            </select>
            <br>
            <input class="input2" type="submit" value="确定" style="background:#79c2ed;color: white; font-size: 20px; border: 0px;outline:none;cursor: pointer;"/>
        </form>
    </div>
</div>
</body>
<script src="js/jquery_2.1.4_baidu_min.js"></script>
<script src="js/jquery-form.js"></script>
<script>
    function uploadImage() {
        //编写ajax
        var obj={
            url:"upload.do",
            dataType:"json",
            type:"post",
            success:function(data){
                $("#img").attr("src",data.imagePath);
                $("#pic").attr("value",data.imagePath);
            }
        };
        $("#imm").ajaxSubmit(obj);
    }
</script>
</html>
