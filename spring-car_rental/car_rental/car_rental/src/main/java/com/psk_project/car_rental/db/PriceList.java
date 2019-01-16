package com.psk_project.car_rental.db;

public class PriceList implements  java.io.Serializable {
    private int priceListID =-1;
    private int priceForH =-1;
    private int priceForKm =-1;
    private  int changeDate =-1;
    private int carID =-1;

    public void update(PriceList pl) {
        if(carID!=-1) carID = pl.carID;
        if(priceListID!=-1) priceListID=pl.priceListID;
        if(priceForH!=-1) priceForH=pl.priceForH;
        if(priceForKm!=-1) priceForKm=pl.priceForKm;
        if(changeDate!=-1) changeDate=pl.changeDate;
        if(carID!=-1) carID=pl.carID;
    }

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