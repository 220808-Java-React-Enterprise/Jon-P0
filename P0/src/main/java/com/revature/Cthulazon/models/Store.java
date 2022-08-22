package com.revature.Cthulazon.models;

import java.util.List;

public class Store {
    String storeID;
    String storeNumber;
    String city;
    String soulInventory;
public Store()
{}

        public Store(String storeID, String city, String soulInventory) {
        this.storeID = storeID;
        this.city = city;
        this.soulInventory = soulInventory;
    }

    public Store(String storeID, String city) {
        this.storeID = storeID;
        this.city = city;
    }

    public Store(String storeID) {
    this.storeID=storeID;
    }


    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setCity(String location) {
        this.city = city;
    }

    public void setSoulInventory(String soulInventory) {
        this.soulInventory = soulInventory;
    }

    public String getStoreID() {
        return storeID;
    }

    public String getCity() {
        return city;
    }

    public String getSoulInventory() {
        return soulInventory;
    }
}
