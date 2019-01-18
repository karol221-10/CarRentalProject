
package com.psk_project.car_rental.db;



public class Customer implements java.io.Serializable {

    private int customerId = -1;
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
    private String remarks;


    public void update(Customer cust) {
        if (cust.name != null) name = cust.name;
        if (cust.surname != null) surname = cust.surname;
        if (cust.pesel != null) pesel = cust.pesel;
        if (cust.phone != null) phone = cust.phone;
        if (cust.documentType != null) documentType = cust.documentType;
        if (cust.idNumber != null) idNumber = cust.idNumber;
        if (cust.place != null) place = cust.place;
        if (cust.address != null) address = cust.address;
        if (cust.postal != null) postal = cust.postal;
        if (cust.postOffice != null) postOffice = cust.postOffice;
        if (cust.remarks != null) remarks = cust.remarks;
    }


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

    public String getRemarks() { return remarks; }

    public void setRemarks(String remarks) { this.remarks = remarks;
    }
}


