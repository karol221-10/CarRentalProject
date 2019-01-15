package com.psk_project.car_rental.db;

import javax.persistence.*;

@Entity
@Table(name = "Klient")
public class Customer {

    @Column(name = "id_klienta")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int customerId;

    @Column(name = "imie", nullable = false, length = 30)
    private String name;

    @Column(name = "nazwisko", nullable = false, length = 20)
    private String surname;

    @Column(name = "PESEL", nullable = false, length = 11)
    private String pesel;

    @Column(name = "nr_telefonu", nullable = true, unique = true, length = 12)
    private String phone;

    @Column(name = "rodzaj_dokumentu", nullable = false, length = 15)
    private String documentType;

    @Column(name = "nr_dowodu", nullable = false, length = 10)
    private String idNumber;

    @Column(name = "miejscowosc", nullable = false, length = 30)
    private String place;

    @Column(name = "adres", nullable = false, length = 30)
    private String address;

    @Column(name = "kod_pocztowy", nullable = false, length = 6)
    private String postal;

    @Column(name = "poczta", nullable = false, length = 30)
    private String postOffice;

    @Column(name = "uwagi", nullable = false, length = 200)
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
