package com.psk_project.car_rental.db;

public class Invoice implements java.io.Serializable {
    private int invoiceID = -1;
    private int carReturnID = -1;
    private int price = -1;

    public void update(Invoice newInvoice) {
        if(newInvoice.carReturnID!=-1) carReturnID=newInvoice.carReturnID;
        if(newInvoice.price!=-1) carReturnID=newInvoice.price;
    }
    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getCarReturnID() {
        return carReturnID;
    }

    public void setCarReturnID(int carReturnID) {
        this.carReturnID = carReturnID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
