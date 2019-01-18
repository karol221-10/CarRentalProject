package com.psk_project.car_rental.db;

import java.math.BigDecimal;

public class Facility implements  java.io.Serializable {
    private int facialityID = -1;
    private String adress;
    private int managerID = -1;
    private  String phoneNumber;

    public void update(Facility fac) {
        if(adress!=null) adress=fac.adress;
        if(managerID != -1) managerID=fac.managerID;
        if(phoneNumber!=null) phoneNumber=fac.phoneNumber;

    }

    public int getFacialityID() {
        return facialityID;
    }

    public void setFacialityID(int facialityID) {
        this.facialityID = facialityID;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}