package com.psk_project.car_rental.db;

public class Invoices implements  java.io.Serializable {
    private int invoicesID = -1;
    private int carID = -1;
    private int clientID = -1;
    private  int workerID = -1;
    private int returnID = -1;

    public void update(Invoices invo){
        if(carID != -1) carID=invo.carID;
        if(clientID != -1) clientID=invo.clientID;
        if(workerID !=-1) workerID = invo.workerID;
        if(returnID !=-1) returnID= invo.returnID;
    }

    public int getInvoicesID() {
        return invoicesID;
    }

    public void setInvoicesID(int invoicesID) {
        this.invoicesID = invoicesID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public int getReturnID() {
        return returnID;
    }

    public void setReturnID(int returnID) {
        this.returnID = returnID;
    }
}