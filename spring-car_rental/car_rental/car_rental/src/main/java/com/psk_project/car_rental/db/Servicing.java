package com.psk_project.car_rental.db;

public class Servicing implements  java.io.Serializable {
    private int overviewID =-1;
    private int carID = -1;
    private String overviewType;
    private int expirationDate= -1;
    private int executionDate= -1;
    private int price= -1;
    private String comments;

    public void update(Servicing ov) {
        if(carID!=-1) carID = ov.carID;
        if(overviewType!=null) overviewType=ov.overviewType;
        if(expirationDate!=-1) expirationDate=ov.expirationDate;
        if(executionDate!=-1) executionDate=ov.executionDate;
        if(price!=-1) price=ov.price;
        if(comments!=null) comments=ov.comments;
    }

    public int getOverviewID() {
        return overviewID;
    }

    public void setOverviewID(int overviewID) {
        this.overviewID = overviewID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getOverviewType() {
        return overviewType;
    }

    public void setOverviewType(String overviewType) {
        this.overviewType = overviewType;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(int executionDate) {
        this.executionDate = executionDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


}