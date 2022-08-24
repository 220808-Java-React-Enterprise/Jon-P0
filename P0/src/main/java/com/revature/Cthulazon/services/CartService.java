package com.revature.Cthulazon.services;

import com.revature.Cthulazon.dao.CartDAO;
import com.revature.Cthulazon.models.Cart;

public class CartService {
    private final CartDAO cartDAO;

    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public void register(Cart cart) {
        cartDAO.save(cart);
    }
    public void firstTime(Cart cart) {
        cartDAO.firstTime(cart);
    }
public void update(Cart cart)
{
    cartDAO.update(cart);
}
    public Cart getById(String userID){
        Cart userCart=cartDAO.getById(userID);
        return userCart;
    }



}
