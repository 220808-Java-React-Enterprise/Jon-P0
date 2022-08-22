package com.revature.Cthulazon.models;
import com.revature.Cthulazon.models.*;
import com.revature.Cthulazon.dao.*;
import com.revature.Cthulazon.services.*;

import java.util.Date;

public class Orders {
    String orderID ;
    String cartID ;
    String userID ;
    String storeID;
    Date date;
    double amount;
    public Orders() {
    }

    public Orders(String orderID, String cartID, String userID, String storeID, Date date, double amount){}


    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getCartID() {
        return cartID;
    }

    public String getUserID() {
        return userID;
    }

    public String getStoreID() {
        return storeID;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
