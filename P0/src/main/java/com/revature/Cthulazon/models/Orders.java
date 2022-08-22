package com.revature.Cthulazon.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Orders {

    String orderID ;
    String userID ;
    String storeID;
    String date;
    int amount;

    public Orders() {
    }

    public Orders(String orderID, String cartID, String userID, String storeID, String date, int amount){}


    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setDate(Date date) {


    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrderID() {
        return orderID;
    }


    public String getUserID() {
        return userID;
    }

    public String getStoreID() {
        return storeID;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }


}
