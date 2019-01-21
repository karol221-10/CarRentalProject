package com.psk_project.car_rental.db.views_db;

import java.util.Date;

public class WhoRented {
    //VKTOWYPOZYCZYL


    private int customerId;//ID_PRACOWNIKA
    private String name;//imie
    private String surmane;//nazwisko
    private int rentID;//ID_wypozyczenia
    private Date rentDate;//datawypozyczenia

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurmane() {
        return surmane;
    }

    public void setSurmane(String surmane) {
        this.surmane = surmane;
    }

    public int getRentID() {
        return rentID;
    }

    public void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }
}
