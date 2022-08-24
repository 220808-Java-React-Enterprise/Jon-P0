package com.revature.Cthulazon.models;
import java.util.List;

public class Cart {
    String cartID;
    List<Product> listOfSouls;
    String soulID;
    String userID;
    public Cart(){
    }

    public Cart(String cartID, String userID,String soulID)
    {
        this.cartID=cartID;
        this.userID=userID;
        this.soulID=soulID;
    }
    public Cart(String cartID, String userID,String SoulID,List<Product> listOfSouls)
    {
        this.cartID=cartID;
        this.listOfSouls=listOfSouls;
        this.userID=userID;
    }

    public Cart(String cartID, String userID) {
        this.cartID=cartID;
        this.userID=userID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }


    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setSoulID(String soulID) {
        this.soulID = soulID;
    }

    public String getCartID() {
        return cartID;
    }

    public String getUserID() {
        return userID;
    }

    public String getSoulID() {
        return soulID;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID='" + cartID + '\'' +
                ",userID='" + userID+ '\'' +
                ", soulID='" + soulID + '\'' +
                '}';
    }
}
