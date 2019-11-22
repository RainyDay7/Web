package com.nuesoft.controller;

import com.nuesoft.po.Admin;
import com.nuesoft.po.Category;
import com.nuesoft.po.Product;
import com.nuesoft.service.AdminService;
import com.nuesoft.service.CategorySevice;
import com.nuesoft.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/AdminLoginServlet.do")
public class AdminLoginServlet extends javax.servlet.http.HttpServlet {

    AdminService adminService= new AdminService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        this.doGet(request, response);//这样所有的提交都会在get中进行，逻辑更清晰
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String key = request.getParameter("key");//后台获取到前台的数据
        switch (key){
            case "3":loginAdmin(request, response); break;
            case "4":seePro(request, response);break;
        }
    }

    private void seePro(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();//存在的话会获取，不存在会存入
        ProductService productService = new ProductService();
        List<Product> adminproducts = new ArrayList<>();
        adminproducts = productService.getProducts();
        session.setAttribute("adminproducts" ,adminproducts);
        System.out.println("adminproducts");

        CategorySevice categorySevice = new CategorySevice();
        List<Category> categories = new ArrayList<>();
        categories = categorySevice.getCategory();
        System.out.println(categories);
        session.setAttribute("categories", categories);
        for(Product product: adminproducts) System.out.println(product);
        //转，跳转页面
        try {
            request.getRequestDispatcher("Background_Management_System.jsp").forward(request, response);//里面就是跳转页面的路劲，不然就会使白屏
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loginAdmin(HttpServletRequest request, HttpServletResponse response) {

        //取值 用到前面的name属性
        String adminame = request.getParameter("adminame");
        String password = request.getParameter("password");
        System.out.println("用户名+密码"+adminame+":"+password);
        //调用；进行逻辑处理，用户密码与数据库比对
        Admin admin = new Admin();
        admin.setAdminame(adminame);
        admin.setAdminpwd(password);
        System.out.println(adminame+password);
        List<Admin> admins = adminService.selectAdmin(admin);
        System.out.println(admins.get(0));
        if(admins.size()>0)
        {
            seePro(request, response);
        }
    }
}
