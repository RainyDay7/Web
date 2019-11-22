package com.nuesoft.dao;

import com.nuesoft.po.Admin;
import com.nuesoft.po.Product;
import com.nuesoft.po.ShoppingCart;
import com.nuesoft.po.User;
import com.nuesoft.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    private QueryRunner queryRunner = null;

    public int addToCart(ShoppingCart car){
        int rows = 0;
        String sql = "insert into shoppingcart values(null,?,?,?,?,?,?)";
        QueryRunner queryRunner = C3P0Utils.getQueryRunner();
        try {
            System.out.println("cat"+car);
            rows = queryRunner.update(sql, car.getPid(),car.getPname(),car.getPrice(),car.getCount(),car.getImgurl(),car.getUid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    public List<ShoppingCart> selectShoppingCartByUID(int uid){
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        String sql = "select * from shoppingcart where uid=?";
        QueryRunner queryRunner = C3P0Utils.getQueryRunner();
        try {
            shoppingCarts= queryRunner.query(sql, new BeanListHandler<ShoppingCart>(ShoppingCart.class), uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCarts;
    }
    public int deleteFromCart(int pid){
        int rows = 0;
        String sql = "delete from shoppingcart where pid=?";
        QueryRunner queryRunner = C3P0Utils.getQueryRunner();
        try {
            rows = queryRunner.update(sql, pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    public List<ShoppingCart> getShoppingCartByPIDandUID(int uid, int pid){
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        String sql = "select * from shoppingcart where uid=? and pid=?";
        QueryRunner queryRunner = C3P0Utils.getQueryRunner();
        try {
            shoppingCarts= queryRunner.query(sql, new BeanListHandler<ShoppingCart>(ShoppingCart.class), uid, pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCarts;
    }
    public int updateCount(int uid, int pid, int count){
        int rows=0;
        String sql="update shoppingcart set count=? where uid=? and pid=?";
        QueryRunner queryRunner = C3P0Utils.getQueryRunner();
        try {
            rows = queryRunner.update(sql, count, uid, pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(rows);
        return rows;
    }

}
