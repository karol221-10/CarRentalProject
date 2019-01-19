package com.psk_project.car_rental.db;

import java.util.Date;

public class PriceList implements  java.io.Serializable {
    private int priceListID =-1;
    private int priceForH =-1;
    private int priceForKm =-1;
    private Date changeDate;


    public void update(PriceList pl) {
        if(priceForH!=-1) priceForH=pl.priceForH;
        if(priceForKm!=-1) priceForKm=pl.priceForKm;
        if(changeDate!= null) changeDate=pl.changeDate;
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

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

}