package com.psk_project.car_rental.db;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int customerId;

    private String name;
    private String surname;
    private String pesel;
    private String phone;
    private String documentType;
    private String idNumber;
    private String place;
    private String address;
    private String postal;
    private String postOffice;
    private String rentalID;


    public Customer() { }

    public int getCustomerId() { return customerId; }

    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getPesel() { return pesel; }

    public void setPesel(String pesel) { this.pesel = pesel; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getDocumentType() { return documentType; }

    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getIdNumber() { return idNumber; }

    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }

    public String getPlace() { return place; }

    public void setPlace(String place) { this.place = place; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPostal() { return postal; }

    public void setPostal(String postal) { this.postal = postal; }

    public String getPostOffice() { return postOffice; }

    public void setPostOffice(String postOffice) { this.postOffice = postOffice; }

    public String getRentalID() { return rentalID; }

    public void setRentalID(String rentalID) { this.rentalID = rentalID;
    }
}
