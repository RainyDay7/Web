package com.nuesoft.dao;

import com.nuesoft.po.Category;
import com.nuesoft.po.Product;
import com.nuesoft.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private QueryRunner queryRunner=null;
    public List<Category> getCategory(){
        List<Category> categories = new ArrayList<>();
        String sql="select * from category";
        queryRunner= C3P0Utils.getQueryRunner();
        try {
            categories = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
