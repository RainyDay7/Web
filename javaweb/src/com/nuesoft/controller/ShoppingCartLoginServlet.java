package com.nuesoft.controller;

import com.nuesoft.dao.CartDao;
import com.nuesoft.po.Product;
import com.nuesoft.po.ShoppingCart;
import com.nuesoft.service.CartService;
import com.nuesoft.service.ProductService;
import com.nuesoft.service.UserService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet("/ShoppingCartLoginServlet.do")
public class ShoppingCartLoginServlet extends javax.servlet.http.HttpServlet {

    CartService cartService = new CartService();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        this.doGet(request, response);//这样所有的提交都会在get中进行，逻辑更清晰
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String key = request.getParameter("key");//后台获取到前台的数据

        switch (key){
            case "1":Add(request, response); break;
            case "2":See(request, response); break;
            case "3":Delete(request, response);break;
            case "4":Uplode(request, response);break;
        }
    }

    private void Uplode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String pid = request.getParameter("pid");
        Integer uid = (Integer)session.getAttribute("uid");
        String count = request.getParameter("count");
        System.out.println("count"+count);
        cartService.updateCount(uid, Integer.parseInt(pid),Integer.parseInt(count));

        System.out.println("count"+count);
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String pid = request.getParameter("pid");
        System.out.println(pid);
        int rows = cartService.deleteFromCart(Integer.parseInt(pid));
        System.out.println(rows);
        try {
            request.getRequestDispatcher("/ShoppingCartLoginServlet.do?key=2").forward(request, response);//里面就是跳转页面的路劲，不然就会使白屏
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void See(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("uid");
        System.out.println("uid"+uid);

        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        shoppingCarts = cartService.selectShoppingCartByUID(uid);
        for(ShoppingCart shoppingCart:shoppingCarts) System.out.println(shoppingCart);
        session.setAttribute("shoppingCarts",shoppingCarts);
        try {
            request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);//里面就是跳转页面的路劲，不然就会使白屏
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) {//加入购物车
        HttpSession session = request.getSession();
        String pid = request.getParameter("pid");
        Integer uid = (Integer) session.getAttribute("uid");

        String amount = request.getParameter("amount");
        System.out.println("amount"+amount);

        ProductService productService = new ProductService();
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        shoppingCarts = cartService.getShoppingCartByPIDandUID(uid, Integer.parseInt(pid));
        if(shoppingCarts.size()>0){//购物车里面已经存在当前商品
            System.out.println(shoppingCarts.size());
            int count = Integer.parseInt(amount)+shoppingCarts.get(0).getCount();
            cartService.updateCount(uid, Integer.parseInt(pid), count);
            System.out.println("count"+count);
        }
        else{
            List<Product> pros = new ArrayList<>();
            pros = productService.getProductByID(Integer.parseInt(pid));

            ShoppingCart car = new ShoppingCart();
            car.setCount(Integer.parseInt(amount)); car.setUid(uid);car.setPrice(pros.get(0).getPrice());
            car.setPname(pros.get(0).getPname());car.setImgurl(pros.get(0).getImgurl()); car.setPid(pros.get(0).getPid());

            cartService.addToCart(car);
        }

       try {
         request.getRequestDispatcher("ShoppingCartLoginServlet.do?key=2").forward(request, response);//里面就是跳转页面的路劲，不然就会使白屏
       } catch (ServletException e) {
            e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }


}
