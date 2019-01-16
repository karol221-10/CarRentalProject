package com.psk_project.car_rental.services;

import com.psk_project.car_rental.db.Worker;
import com.psk_project.car_rental.db_connection.JdbcOracleConnection;
import oracle.jdbc.connector.OracleConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerService {
    public List<Worker> getWorkerList() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM pracownik");
        List<Object[]> rows = query.getResultList();
        List<Worker> resultList = new ArrayList<Worker>();
        for(Object[] object : rows) {
            Worker worker = new Worker();
            worker.setWorkerID(((BigDecimal)object[0]).intValue());
            worker.setName((String)object[1]);
            worker.setSurname((String)object[2]);
            worker.setPesel((String)object[3]);
            worker.setPhone((String)object[4]);
            worker.setSex((String)object[5]);
            worker.setCity((String)object[6]);
            worker.setAddress((String)object[7]);
            worker.setPostal((String)object[8]);
            worker.setPostOffice((String)object[9]);
            if(object[10]==null) worker.setRentalID(-1);
            else worker.setRentalID(((BigDecimal)object[10]).intValue());
           if(object[11]==null) worker.setSalary(-1); else worker.setSalary(((BigDecimal)object[11]).intValue());
            resultList.add(worker);
        }
        return resultList;
    }
    public Worker getWorker(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM pracownik WHERE id_pracownika=?");
        query.setParameter(1,ID);
        List<Object[]> objects = query.getResultList();
        if(objects.size()==1) {
            Object[] object = objects.get(0);
            Worker worker = new Worker();
            worker.setWorkerID(((BigDecimal)object[0]).intValue());
            worker.setName((String)object[1]);
            worker.setSurname((String)object[2]);
            worker.setPesel((String)object[3]);
            worker.setPhone((String)object[4]);
            worker.setSex((String)object[5]);
            worker.setCity((String)object[6]);
            worker.setAddress((String)object[7]);
            worker.setPostal((String)object[8]);
            worker.setPostOffice((String)object[9]);
            if(object[10]==null) worker.setRentalID(-1);
            else worker.setRentalID(((BigDecimal)object[10]).intValue());
            if(object[11]==null) worker.setSalary(-1); else worker.setSalary(((BigDecimal)object[11]).intValue());
            return worker;
        }
        else return new Worker();
    }
    public void updateWorker(Worker input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Worker oldWorker = getWorker(input.getWorkerID());
        oldWorker.update(input);
        Query q = entityManager.createNativeQuery("UPDATE pracownik SET imie=?,nazwisko=?,pesel=?,nr_telefonu=?,miejscowosc=?,adres=?,kod_pocztowy=?,poczta=?,plec=?,pensja=? WHERE id_pracownika=?");
        q.setParameter(1,oldWorker.getName());
        q.setParameter(2,oldWorker.getSurname());
        q.setParameter(3,oldWorker.getPesel());
        q.setParameter(4,oldWorker.getPhone());
        q.setParameter(5,oldWorker.getCity());
        q.setParameter(6,oldWorker.getAddress());
        q.setParameter(7,oldWorker.getPostal());
        q.setParameter(8,oldWorker.getPostOffice());
        q.setParameter(9,oldWorker.getSex());
        q.setParameter(10,oldWorker.getSalary());
        q.setParameter(11,oldWorker.getWorkerID());
        q.executeUpdate();
        if(oldWorker.getRentalID()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE pracownik SET id_placowki=? WHERE id_pracownika=?");
            qu.setParameter(1,oldWorker.getRentalID());
            qu.setParameter(2,oldWorker.getWorkerID());
            qu.executeUpdate();
        }
        entityManager.getTransaction().commit();
    }
    public void addWorker(Worker input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("INSERT INTO pracownik(ID_pracownika,imie,nazwisko,pesel,nr_telefonu,miejscowosc,adres,kod_pocztowy,poczta,plec,pensja) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        q.setParameter(1,input.getWorkerID());
        q.setParameter(2,input.getName());
        q.setParameter(3,input.getSurname());
        q.setParameter(4,input.getPesel());
        q.setParameter(5,input.getPhone());
        q.setParameter(6,input.getCity());
        q.setParameter(7,input.getAddress());
        q.setParameter(8,input.getPostal());
        q.setParameter(9,input.getPostOffice());
        q.setParameter(10,input.getSex());
        q.setParameter(11,input.getSalary());
        q.executeUpdate();
        if(input.getRentalID()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE pracownik SET id_placowki=? WHERE id_pracownika=?");
            qu.setParameter(1,input.getRentalID());
            qu.setParameter(2,input.getWorkerID());
            qu.executeUpdate();
        }
        entityManager.getTransaction().commit();
    }
    public void deleteWorker(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("DELETE FROM pracownik WHERE id_pracownika=?");
        q.setParameter(1,ID);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
}