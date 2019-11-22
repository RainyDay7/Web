package com.nuesoft.service;

import com.nuesoft.dao.CartDao;
import com.nuesoft.po.ShoppingCart;

import java.util.List;

public class CartService {
    //服务层，需要加密的话可以在业务逻辑层处理，服务层调用dao层

    CartDao cartDao = new CartDao();
    public int addToCart(ShoppingCart car){return cartDao.addToCart(car);}
    public List<ShoppingCart> selectShoppingCartByUID(int uid){return cartDao.selectShoppingCartByUID(uid);}
    public int deleteFromCart(int pid){return  cartDao.deleteFromCart(pid);}
    public List<ShoppingCart> getShoppingCartByPIDandUID(int uid, int pid){return cartDao.getShoppingCartByPIDandUID(uid, pid);}
    public int updateCount(int uid, int pid, int count){return cartDao.updateCount(uid, pid, count);}
}
