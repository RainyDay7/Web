package com.nuesoft.controller;

import com.nuesoft.po.Admin;
import com.nuesoft.po.Product;
import com.nuesoft.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductDetailsServlet.do")
public class ProductDetailsServlet extends javax.servlet.http.HttpServlet {
    ProductService productService = new ProductService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        this.doGet(request, response);//这样所有的提交都会在get中进行，逻辑更清晰
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String pid = request.getParameter("pid");//后台获取到前台的数据
        //调用；进行逻辑处理，用户密码与数据库比对
        Product product  = new Product();
        product.setPid( Integer.parseInt(pid));

        List<Product> products = productService.getProductByID(product.getPid());
        if(products.size()>0)
        {
            //存入
            HttpSession session = request.getSession();//存在的话会获取，不存在会存入
            session.setAttribute("pid", products.get(0).getPid());
            session.setAttribute("pname", products.get(0).getPname());
            session.setAttribute("price",products.get(0).getPrice());
            session.setAttribute("imgurl",products.get(0).getImgurl());
            session.setAttribute("pdesc",products.get(0).getPdesc());
            System.out.println(products.get(0));
            try {
                //转，跳转页面
                request.getRequestDispatcher("Goods_Details.jsp").forward(request, response);//里面就是跳转页面的路劲，不然就会使白屏
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
