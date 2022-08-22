package com.revature.Cthulazon.services;

import com.revature.Cthulazon.dao.CartDAO;
import com.revature.Cthulazon.models.Cart;

public class CartService {
    private final CartDAO cartDAO;

    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public Cart getById(String userID){
        Cart userCart=cartDAO.getById(userID);
        return userCart;
    }

}
