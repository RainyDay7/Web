package com.nuesoft.dao;

import com.nuesoft.po.Admin;
import com.nuesoft.po.User;
import com.nuesoft.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //控制层
//最早是用jdbc 逻辑比c3p0复杂，
//创建链接对象，加载驱动，加载对象，…………大概7步
    private QueryRunner queryRunner = null;
    public List<User>  selectUser(User user){
        List<User> users = new ArrayList<User>();
        String sql = "select * from users where username=? and password=?";
        queryRunner = C3P0Utils.getQueryRunner();
        try {
            users = queryRunner.query(sql, new BeanListHandler<User>(User.class),user.getUsername(), user.getPassword() );//后面是传进去的两个参数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public int addUser(User user){
        int rows = 0;
        String sql = "insert into users values(null, ?, ?, ?, ?, ?)";
        QueryRunner queryRunner = C3P0Utils.getQueryRunner();
        try {
            rows = queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getPhone());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    public List<User> selectUserByID(int uid){
        List<User> users = new ArrayList<User>();
        String sql = "select * from users where uid=?";
        queryRunner = C3P0Utils.getQueryRunner();
        try {
            users = queryRunner.query(sql, new BeanListHandler<User>(User.class),uid);//后面是传进去的两个参数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
