package com.psk_project.car_rental.services;


import com.psk_project.car_rental.db.Car;
import com.psk_project.car_rental.db.Customer;
import com.psk_project.car_rental.db.Insurance;
import com.psk_project.car_rental.db.Worker;
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
public class InsuranceService {
    private Insurance createInsurance(Object[] object) {
        Insurance ins = new Insurance();
        ins.setInsuranceID(((BigDecimal)object[0]).intValue());
        ins.setCarID(((BigDecimal)object[1]).intValue());
        ins.setInsuranceType((String)object[2]);
        ins.setStartDate((Date)object[3]);
        ins.setEndDate((Date)object[4]);
        ins.setPrice(((BigDecimal)object[5]).intValue());
        ins.setInclusion((Date)object[6]);
        return ins;
    }
    public List<Insurance> getList() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM ubezpieczenia");
        List<Object[]> rows = query.getResultList();
        List<Insurance> resultList = new ArrayList<Insurance>();
        for(Object[] object : rows) {
            resultList.add(createInsurance(object));
        }
        return resultList;
    }
    public Insurance get(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM ubezpieczenia WHERE id_ubezpieczenia=?");
        query.setParameter(1,ID);
        List<Object[]> objects = query.getResultList();
        if(objects.size()==1) {
            Object[] object = objects.get(0);
            return createInsurance(object);
        }
        else return new Insurance();
    }

    public void update(Insurance input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Insurance oldInsurance = get(input.getInsuranceID());
        oldInsurance.update(input);
        Query q = entityManager.createNativeQuery("UPDATE ubezpieczenia SET id_auta=?, rodzaj_ubezpieczenia=?, data_poczatku_ubezpieczenia=?, data_konca_ubezpieczenia=?,skladka_roczna=?,data_zawarcia_ubezpieczenia=?");
        q.setParameter(1,oldInsurance.getCarID());
        q.setParameter(2,oldInsurance.getInsuranceType());
        q.setParameter(3,oldInsurance.getStartDate());
        q.setParameter(4,oldInsurance.getEndDate());
        q.setParameter(5,oldInsurance.getPrice());
        q.setParameter(6,oldInsurance.getInclusion());
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public void add(Insurance input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("INSERT INTO ubezpieczenia VALUES(?,?,?,?,?,?,?)");
        q.setParameter(1,input.getInsuranceID());
        q.setParameter(2,input.getCarID());
        q.setParameter(3,input.getInsuranceType());
        q.setParameter(4,input.getStartDate());
        q.setParameter(5,input.getEndDate());
        q.setParameter(6,input.getPrice());
        q.setParameter(7,input.getInclusion());
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
    public void delete(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("DELETE FROM ubezpieczenia WHERE id_ubezpieczenia=?");
        q.setParameter(1,ID);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
