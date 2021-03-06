package com.psk_project.car_rental.db;

import java.util.Date;

public class Rental {
    private int rentalId= -1;
    private int carId =-1;
    private int customerId= -1;
    private int workerId =-1;
    private String odometerBeforeRental;
    private Date rentalDate ;
    private int bail = -1;
    private int priceListId =-1;

    public void update(Rental rental) {
        if(rental.rentalId!= -1) rentalId=rental.rentalId;
        if(rental.carId!= -1) carId=rental.carId;
        if(rental.customerId!= -1) customerId=rental.customerId;
        if(rental.workerId!= -1) workerId=rental.workerId;
        if(rental.odometerBeforeRental!= null) odometerBeforeRental=rental.odometerBeforeRental;
        if(rental.rentalDate!= null) rentalDate=rental.rentalDate;
        if(rental.bail!= -1) bail=rental.bail;
        if(rental.priceListId!= -1) priceListId=rental.priceListId;
    }
    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getOdometerBeforeRental() {
        return odometerBeforeRental;
    }

    public void setOdometerBeforeRental(String odometerBeforeRental) {
        this.odometerBeforeRental = odometerBeforeRental;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getBail() {
        return bail;
    }

    public void setBail(int bail) {
        this.bail = bail;
    }

    public int getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(int priceListId) {
        this.priceListId = priceListId;
    }
}
