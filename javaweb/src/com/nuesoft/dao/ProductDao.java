package com.nuesoft.dao;

import com.nuesoft.po.Product;
import com.nuesoft.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private QueryRunner queryRunner=null;

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        String sql="select * from products";
        queryRunner= C3P0Utils.getQueryRunner();
        try {
            products = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> getPeoductByID(int pid){
        List<Product> products = new ArrayList<>();
        String sql="select * from products where pid=?";
        queryRunner = C3P0Utils.getQueryRunner();
        try {
            products = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public int addProduct(Product product){
        int rows =0;
        String sql = "insert into products values(null, ?, ?, ?, ?, ?)";
        queryRunner = C3P0Utils.getQueryRunner();
        try {
            rows = queryRunner.update(sql, product.getPname(), product.getPrice(), product.getImgurl(), product.getPdesc(), product.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    public int deleteProductByID(int pid){
        int rows =0;
        String sql = "delete from products where pid=?";
        queryRunner = C3P0Utils.getQueryRunner();
        try {
            rows = queryRunner.update(sql, pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("rows"+rows);
        return rows;
    }
    public int updateProduct(Product newpro, Product oldpro){
        int rows=0;
        String sql="update products set  pname=?, price=?, imgurl=?, pdesc=?, cid=? where pid=?";
        queryRunner = C3P0Utils.getQueryRunner();
        try {
            rows = queryRunner.update(sql, newpro.getPname(), newpro.getPrice(), newpro.getImgurl(),newpro.getPdesc(), newpro.getCid(), oldpro.getPid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}


