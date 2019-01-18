package com.psk_project.car_rental.db;

import java.util.Date;

public class CarReturn implements java.io.Serializable {
    private int returnID = -1;
    private int rentalID = -1;
    private int workerID = -1;
    private Date date;

    public void update(CarReturn cr) {
        if(cr.returnID!=-1) returnID=cr.returnID;
        if(cr.rentalID!=-1) rentalID=cr.rentalID;
        if(cr.workerID!=-1) workerID=cr.workerID;
        if(date!=null) date=cr.date;
    }

    public int getReturnID() {
        return returnID;
    }

    public void setReturnID(int returnID) {
        this.returnID = returnID;
    }

    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
