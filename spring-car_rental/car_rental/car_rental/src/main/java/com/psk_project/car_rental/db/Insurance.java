package com.psk_project.car_rental.db;

import java.util.Date;

public class Insurance implements java.io.Serializable {
    private int insuranceID = -1;
    private int carID = -1;
    private Date startDate;
    private Date endDate;
    private int price = -1;
    private Date inclusion;

    private String insuranceType;
    public void update(Insurance fac) {
        if(fac.carID!=-1) carID=fac.carID;
        if(fac.startDate!=null) startDate=fac.startDate;
        if(fac.endDate!=null) endDate=fac.endDate;
        if(fac.price!=-1) price=fac.price;
        if(fac.inclusion!=null) inclusion=fac.inclusion;
    }
    public int getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getInclusion() {
        return inclusion;
    }

    public void setInclusion(Date inclusion) {
        this.inclusion = inclusion;
    }
    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

}
