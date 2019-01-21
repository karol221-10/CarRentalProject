package com.psk_project.car_rental.db.views_db;

import java.util.Date;

public class ServiceTerm {
    private int carID= -1; //ID_AUTA
    private int serviceId =-1; //ID_PRZEGLADU
    private String mark;  //MARKA
    private String model;//M_MODEL
    private Date expirationDate;//DATA_WAZNOSCI_PRZEGLADU

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}

