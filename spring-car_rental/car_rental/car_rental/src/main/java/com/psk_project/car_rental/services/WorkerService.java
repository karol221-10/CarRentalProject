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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class WorkerService {

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
}
