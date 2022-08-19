package com.revature.Cthulazon.models;

import java.util.List;

public class Store {
    String storeID;
    String location;
    int soulInventory;

    public Store(String storeID, String location, int soulInventory) {
        this.storeID = storeID;
        this.location = location;
        this.soulInventory = soulInventory;
    }

    public Store(String storeID, String location) {
        this.storeID = storeID;
        this.location = location;
    }


    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSoulInventory(int soulInventory) {
        this.soulInventory = soulInventory;
    }

    public String getStoreID() {
        return storeID;
    }

    public String getLocation() {
        return location;
    }

    public int getSoulInventory() {
        return soulInventory;
    }
}
