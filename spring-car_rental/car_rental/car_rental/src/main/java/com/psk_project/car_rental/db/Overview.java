package com.psk_project.car_rental.db;

public class Overview implements  java.io.Serializable {
    private int overviewID =-1;
    private int carID = -1;
    private String overviewType;
    private String expirationDate;
    private String executionDate;
    private int price= -1;
    private String comments;

    public void update(Overview ov) {
        if(carID!=-1) carID = ov.carID;
        if(overviewType!=null) overviewType=ov.overviewType;
        if(expirationDate!=null) expirationDate=ov.expirationDate;
        if(executionDate!=null) executionDate=ov.executionDate;
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
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