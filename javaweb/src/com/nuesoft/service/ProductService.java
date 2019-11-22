package com.nuesoft.service;

import com.nuesoft.dao.ProductDao;
import com.nuesoft.po.Product;
import com.nuesoft.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    ProductDao productDao=new ProductDao();
    public List<Product> getProducts(){
        return productDao.getProducts();
    }
    public List<Product> getProductByID(int pid){return productDao.getPeoductByID(pid);}
    public int addProduct(Product product){return  productDao.addProduct(product);}
    public int deleteProductByID(int pid){return productDao.deleteProductByID(pid);}
    public int updateProduct(Product newpro, Product oldpro){return productDao.updateProduct(newpro, oldpro);}
}
