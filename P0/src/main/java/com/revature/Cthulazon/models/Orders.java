package com.revature.Cthulazon.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Orders {

    String orderID;
    String userID;
    String storeID;
    String date;
    int amount;

    public Orders() {
    }

    public Orders(String orderID, String userID, String storeID, String date, int amount) {
        this.orderID = orderID;
        this.userID = userID;
        this.storeID = storeID;
        this.date = date;
        this.amount = amount;

    }


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

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID='" + orderID + '\'' +
                ", userID='" + userID + '\'' +
                ", storeID='" + storeID + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }
}
