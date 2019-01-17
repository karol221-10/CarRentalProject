package com.psk_project.car_rental.services;


import com.psk_project.car_rental.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService {
    private Invoice createInvoice(Object[] object) {
        Invoice ins = new Invoice();
        ins.setInvoiceID(((BigDecimal)object[0]).intValue());
        ins.setCarReturnID(((BigDecimal)object[1]).intValue());
        ins.setPrice(((BigDecimal)object[2]).intValue());
        return ins;
    }
    public List<Invoice> getList() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM faktury");
        List<Object[]> rows = query.getResultList();
        List<Invoice> resultList = new ArrayList<>();
        for(Object[] object : rows) {
            resultList.add(createInvoice(object));
        }
        return resultList;
    }
    public Invoice get(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM faktury WHERE id_faktury=?");
        query.setParameter(1,ID);
        List<Object[]> objects = query.getResultList();
        if(objects.size()==1) {
            Object[] object = objects.get(0);
            return createInvoice(object);
        }
        else return new Invoice();
    }

    public void update(Invoice input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Invoice oldInvoice = get(input.getInvoiceID());
        oldInvoice.update(input);
        Query q = entityManager.createNativeQuery("UPDATE faktury SET id_zwrotu=?,oplata=? WHERE id_faktury=?");
        q.setParameter(1,oldInvoice.getCarReturnID());
        q.setParameter(2,oldInvoice.getPrice());
        q.setParameter(3,oldInvoice.getInvoiceID());
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public void add(Invoice input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("INSERT INTO faktury VALUES(?,?,?)");
        q.setParameter(1,input.getInvoiceID());
        q.setParameter(2,input.getCarReturnID());
        q.setParameter(3,input.getPrice());
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
    public void delete(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("DELETE FROM faktury WHERE id_faktury=?");
        q.setParameter(1,ID);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
}