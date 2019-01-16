package com.psk_project.car_rental.db;

public class PriceList implements  java.io.Serializable {
    private int priceListID = -1;
    private int priceForH;
    private int priceForKm;
    private  int changeDate;
    private int carID = -1;

    public int getPriceListID() {
        return priceListID;
    }

    public void setPriceListID(int priceListID) {
        this.priceListID = priceListID;
    }

    public int getPriceForH() {
        return priceForH;
    }

    public void setPriceForH(int priceForH) {
        this.priceForH = priceForH;
    }

    public int getPriceForKm() {
        return priceForKm;
    }

    public void setPriceForKm(int priceForKm) {
        this.priceForKm = priceForKm;
    }

    public int getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(int changeDate) {
        this.changeDate = changeDate;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }
}