package com.nuesoft.service;

import com.nuesoft.dao.CategoryDao;
import com.nuesoft.po.Category;

import java.util.List;

public class CategorySevice {
    CategoryDao categoryDao = new CategoryDao();
    public List<Category> getCategory(){return categoryDao.getCategory();}
}
