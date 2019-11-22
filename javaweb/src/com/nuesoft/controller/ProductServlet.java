package com.nuesoft.controller;

import com.nuesoft.dao.ProductDao;
import com.nuesoft.po.Product;
import com.nuesoft.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProductServlet.do")
public class ProductServlet extends HttpServlet {
    
    
    ProductService productService= new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//防止乱码
        resp.setContentType("text/html;charset=utf-8");
        //查询商品数据d
        String key = req.getParameter("key");
        switch (key){
            case "1":addProduct(req, resp);break;
            case "2":deleteProduct(req, resp);break;
            case "3":getAllProduct(req, resp);break;
            case "4":getProductByID(req, resp);break;
            case "5":updateProduct(req, resp);break;
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) {
        String  pid = req.getParameter("pid");
        String  pname = req.getParameter("pname");
        String  price = req.getParameter("price");
        String  imgurl = req.getParameter("path");
        String  pdesc = req.getParameter("pdesc");
        String  cid = req.getParameter("cid");
        Product newpro = new Product(); Product oldpro = new Product();
        oldpro.setPid(Integer.parseInt(pid));
        newpro.setPname(pname); newpro.setPrice(Double.parseDouble(price));newpro.setImgurl(imgurl);newpro.setPdesc(pdesc); newpro.setCid(Integer.parseInt(cid));
        int rows= productService.updateProduct(newpro,oldpro);
        System.out.println(rows);
        try {
            req.getRequestDispatcher("AdminLoginServlet.do?key=4").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getProductByID(HttpServletRequest req, HttpServletResponse resp) {
        String pid = req.getParameter("pid");
        System.out.println(pid);
        List<Product> productListByID = new ArrayList<>();
        productListByID = productService.getProductByID(Integer.parseInt(pid));
        HttpSession session = req.getSession();
        session.setAttribute("pro", productListByID.get(0));
        try {
            req.getRequestDispatcher("EditProduct.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getAllProduct(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> productList = new ArrayList<>();
        productList = productService.getProducts();
        HttpSession session = req.getSession();
        session.setAttribute("productList", productList);
        for(Product product:productList) System.out.println(product);
        try {
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        String pid = req.getParameter("pid");
        System.out.println(pid);
        productService.deleteProductByID(Integer.parseInt(pid));
        System.out.println("删除结束");
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse response) {
        String  pname = req.getParameter("pname");
        String  price = req.getParameter("price");
        String  imgurl = req.getParameter("path");
        String  pdesc = req.getParameter("pdesc");
        String  cid = req.getParameter("cid");

        Product product = new Product();
        product.setCid(Integer.parseInt(cid)); product.setImgurl(imgurl);
        double price1 =  Double.parseDouble(price);
        product.setPdesc(pdesc); product.setPname(pname); product.setPrice(price1);
        productService.addProduct(product);
        try {
            req.getRequestDispatcher("AdminLoginServlet.do?key=4").forward(req, response);//里面就是跳转页面的路劲，不然就会使白屏
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
