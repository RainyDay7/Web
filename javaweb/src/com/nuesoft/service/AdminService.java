package com.nuesoft.service;

import com.nuesoft.dao.AdminDao;
import com.nuesoft.po.Admin;
import java.util.List;

public class AdminService {
    //服务层，需要加密的话可以在业务逻辑层处理，服务层调用dao层

    AdminDao admindao = new AdminDao();
    public List<Admin> selectAdmin(Admin admin){
        return  admindao.selectAdmin(admin);
    }
}

