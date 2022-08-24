package com.revature.Cthulazon.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Orders {

    String orderID;
    String userID;
    String storeID;
    Date date;
    int amount;

    public Orders() {
    }

<<<<<<< HEAD
<<<<<<< Updated upstream
    public Orders(String orderID, String cartID, String userID, String storeID, String date, int amount){}
=======
    public Orders(String orderID, String userID, String storeID, Date date, int amount) {
=======
    public Orders(String orderID, String userID, String storeID, String date, int amount) {
>>>>>>> bfab96b7f3f01318e73c4eac7b9abff3915cd093
        this.orderID = orderID;
        this.userID = userID;
        this.storeID = storeID;
        this.date = date;
        this.amount = amount;

    }
<<<<<<< HEAD
>>>>>>> Stashed changes
=======
>>>>>>> bfab96b7f3f01318e73c4eac7b9abff3915cd093


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

    public Date getDate() {
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
