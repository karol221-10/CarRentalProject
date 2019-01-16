package com.psk_project.car_rental.db;

public class Worker implements java.io.Serializable {
    private int workerID = -1;
    private String name;
    private String surname;
    private String pesel;
    private String phone;
    private String sex;
    private String city;
    private String address;
    private String postal;
    private String postOffice;
    private int rentalID = -1;
    private int salary = -1;
    private boolean hidden;
    public void update(Worker work) {
        if(work.name!=null) name=work.name;
        if(work.surname!=null) surname=work.surname;
        if(work.pesel!=null) pesel=work.pesel;
        if(work.phone!=null) phone=work.phone;
        if(work.sex!=null) sex=work.sex;
        if(work.city!=null) city=work.city;
        if(work.address!=null) address=work.address;
        if(work.postal!=null) postal=work.postal;
        if(work.postOffice!=null) postOffice=work.postOffice;
        if(work.rentalID!=-1) rentalID=work.rentalID;
        if(work.salary!=-1) salary=work.salary;
    }
    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
