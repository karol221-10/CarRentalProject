package com.psk_project.car_rental.db.views_db;

public class AvailableCar {
    private int carID= -1;//ID_AUTA
    private String mark;//MARKA
    private String model;//M_MODEL

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
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
}
