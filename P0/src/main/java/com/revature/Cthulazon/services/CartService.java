package com.revature.Cthulazon.services;

import com.revature.Cthulazon.models.Cart;
import com.revature.Cthulazon.models.User;

public class CartService {
    private final com.revature.Cthulazon.dao.cartDAO cartDAO;

    public CartService(com.revature.Cthulazon.dao.cartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public void register(Cart cart) {
        cartDAO.save(cart);
    }
    public void firstTime(Cart cart) {
        cartDAO.firstTime(cart);
    }

    public Cart getById(String userID){
        Cart userCart=cartDAO.getById(userID);
        return userCart;
    }

}
