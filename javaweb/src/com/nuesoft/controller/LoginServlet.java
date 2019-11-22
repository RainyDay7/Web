package com.nuesoft.controller;

import com.nuesoft.dao.UserDao;
import com.nuesoft.po.User;
import com.nuesoft.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/login.do")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    UserService userService=new UserService();

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("servlet被初始化了");
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        this.doGet(request, response);//这样所有的提交都会在get中进行，逻辑更清晰
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String key = request.getParameter("key");//后台获取到前台的数据
        switch (key){
            case "1":loginUser(request, response); break;
            case "2":addUser(request, response); break;
        }

    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) {
        //取值 用到前面的name属性
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("输入的用户名+密码"+username+":"+password);
        //调用；进行逻辑处理，用户密码与数据库比对
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        List<User> users = userService.selectUser(user);
        System.out.println();
        if(users.size()>0)
        {
            //存入
            System.out.println("用户名"+users.get(0).getUsername()+",密码"+users.get(0).getPassword());
            HttpSession session = request.getSession();//存在的话会获取，不存在会存入
            session.setAttribute("user", users.get(0).getUsername());
            session.setAttribute("pass", users.get(0).getPassword());
            session.setAttribute("uid",users.get(0).getUid());
            //转，跳转页面
            try {
                request.getRequestDispatcher("/ProductServlet.do?key=3").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String Email = request.getParameter("Email");
        String Phonenumber = request.getParameter("Phonenumber");
        User user = new User(0, username, password, name, Email, Phonenumber);
        int rows = userService.addUser(user);
        System.out.println(rows);
        try {
            request.getRequestDispatcher("login.jsp").forward(request, response);//里面就是跳转页面的路劲，不然就会使白屏
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
