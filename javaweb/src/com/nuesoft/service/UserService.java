package com.nuesoft.service;

import com.nuesoft.dao.UserDao;
import com.nuesoft.po.User;

import java.util.List;

public class UserService {
    //服务层，需要加密的话可以在业务逻辑层处理，服务层调用dao层
    UserDao userDao = new UserDao();
    //登录
    public List<User> selectUser(User user){
        return userDao.selectUser(user);
    }
    public List<User> selectUserByID(int uid){return  userDao.selectUserByID(uid);}
    public int addUser(User user){
        String username = user.getUsername();

        return userDao.addUser(user);
    }
}

