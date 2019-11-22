package com.nuesoft.dao;

import com.nuesoft.po.Admin;
import com.nuesoft.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    private QueryRunner queryRunner = null;

    public List<Admin> selectAdmin(Admin admin){
        List<Admin> admins = new ArrayList<Admin>();
        String sql = "select * from admins where adminame=? and adminpwd=?";
        queryRunner = C3P0Utils.getQueryRunner();
        try {
            admins = queryRunner.query(sql, new BeanListHandler<Admin>(Admin.class),admin.getAdminame(), admin.getAdminpwd() );//后面是传进去的两个参数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }
}
