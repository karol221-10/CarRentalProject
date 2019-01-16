package com.psk_project.car_rental.db;

public class Car implements java.io.Serializable {
    private int carID= -1;
    private String registrationNumber;
    private String mark;
    private String model;
    private int priceListID= -1;
    private String body;
    private String bodyNumber;
    private String productionDate;
    private int enginePower= -1;
    private int mileage= -1;
    private String fuelType;
    private String comments;

    public void update(Car car) {
        if (car.carID != -1) carID = car.carID;
        if (car.registrationNumber != null) registrationNumber = car.registrationNumber;
        if (car.mark != null) mark = car.mark;
        if (car.model != null) model = car.model;
        if (car.priceListID != -1) priceListID = car.priceListID;
        if (car.body != null) body = car.body;
        if (car.bodyNumber != null) bodyNumber = car.bodyNumber;
        if (car.productionDate != null) productionDate = car.productionDate;
        if (car.enginePower != -1) enginePower = car.enginePower;
        if (car.mileage != -1) mileage = car.mileage;
        if (car.fuelType != null) fuelType = car.fuelType;
        if (car.comments != null) comments = car.comments;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPriceListID() {
        return priceListID;
    }

    public void setPriceListID(int priceListID) {
        this.priceListID = priceListID;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBodyNumber() {
        return bodyNumber;
    }

    public void setBodyNumber(String bodyNumber) {
        this.bodyNumber = bodyNumber;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
