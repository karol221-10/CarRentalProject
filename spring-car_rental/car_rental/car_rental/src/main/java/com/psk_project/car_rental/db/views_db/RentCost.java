package com.psk_project.car_rental.db.views_db;

public class RentCost {
    private String mark;//Marka
    private String model; //Model samochodu
    private int priceForH =-1;//Cena za godz
    private int priceForKm =-1;//Cena za km

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
}
