package com.revature.Cthulazon.models;

import java.util.List;

public class Store {
    String storeID;
    String storeNumber;
    String city;
    int soulInventory;

    public Store() {
    }

    public Store(String storeID, String storeNumber, String city, int soulInventory) {
        this.storeID = storeID;
        this.storeNumber = storeNumber;
        this.city = city;
        this.soulInventory = soulInventory;
    }

    public Store(String storeID, String city, int soulInventory) {
        this.storeID = storeID;
        this.city = city;
        this.soulInventory = soulInventory;
    }

    public Store(String storeID, String city) {
        this.storeID = storeID;
        this.city = city;
    }

    public Store(String storeID) {
        this.storeID = storeID;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setCity(String location) {
        this.city = city;
    }

    public void setSoulInventory(int soulInventory) {
        this.soulInventory = soulInventory;
    }

    public String getStoreID() {
        return storeID;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public String getCity() {
        return city;
    }

    public int getSoulInventory() {
        return soulInventory;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeID='" + storeID + '\'' +
                ", storeNumber='" + storeNumber + '\'' +
                ", city='" + city + '\'' +
                ", soulInventory='" + soulInventory + '\'' +
                '}';
    }
}
