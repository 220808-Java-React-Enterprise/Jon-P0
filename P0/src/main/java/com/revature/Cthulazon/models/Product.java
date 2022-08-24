package com.revature.Cthulazon.models;

public class Product {
    String soulID;
    String sanityGrade;
    String storeID;
    int costToBuy;
    boolean avaliable;

    public Product(String soulID, String sanityGrade, int costToBuy, boolean avaliable,String storeID) {
        this.soulID = soulID;
        this.sanityGrade = sanityGrade;
        this.costToBuy = costToBuy;
        this.avaliable = avaliable;
        this.storeID = storeID;
    }

    public void setSoulID(String soulID) {
        this.soulID = soulID;
    }

    public void setSanityGrade(String sanityGrade) {
        this.sanityGrade = sanityGrade;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setCostToBuy(int costToBuy) {
        this.costToBuy = costToBuy;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public String getSoulID() {
        return soulID;
    }

    public String getSanityGrade() {
        return sanityGrade;
    }

    public String getStoreID() {
        return storeID;
    }

    public int getCostToBuy() {
        return costToBuy;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    @Override
    public String toString() {
        return "Product{" +
                "soulID='" + soulID + '\'' +
                ", sanityGrade='" + sanityGrade + '\'' +
                ", storeID='" + storeID + '\'' +
                ", costToBuy=" + costToBuy +
                ", avaliable=" + avaliable +
                '}';
    }
}

