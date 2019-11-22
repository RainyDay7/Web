package com.nuesoft.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

public class C3P0Utils {
    private static QueryRunner queryRunner = null;

    public static QueryRunner getQueryRunner() {// //第一步：创建QueryRunner对象，传入连接池对象
               //在创建QueryRunner对象的时候，如果传入数据对象dataSource，
                //那么在使用QueryRunner对象的方法时候，就不需要传入连接对象
        DataSource dataSource = new ComboPooledDataSource();//自动加载src目录下面的c3p0的配置文件，【c3p0-config.xml】
        queryRunner = new QueryRunner(dataSource);//第二步：会自动从数据源中获取连接(不用关闭连接)
        return queryRunner;
    }
}
