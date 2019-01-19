package com.psk_project.car_rental.services;

import com.psk_project.car_rental.db.Facility;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacilityService {
    public List<Facility> getFacilityList() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM Placowki");
        List<Object[]> rows = query.getResultList();
        List<Facility> resultList = new ArrayList<>();
        for(Object[] object : rows) {
            Facility facility = new Facility();
            facility.setFacialityID(((BigDecimal)object[0]).intValue());
            facility.setAdress((String)object[1]);
            if(object[2]==null) facility.setManagerID(-1); else facility.setManagerID(((BigDecimal)object[2]).intValue());
            facility.setPhoneNumber((String)object[3]);
            resultList.add(facility);
        }
        return resultList;
    }
    public Facility getFacility(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM Placowki WHERE id_placowki =?");
        query.setParameter(1,ID);
        List<Object[]> objects = query.getResultList();
        if(objects.size()==1) {
            Object[] object = objects.get(0);
            Facility facility = new Facility();
            facility.setFacialityID(((BigDecimal)object[0]).intValue());
            facility.setAdress((String)object[1]);
            if(object[2]==null) facility.setManagerID(-1); else facility.setManagerID(((BigDecimal)object[2]).intValue());
            facility.setPhoneNumber((String)object[3]);
            return facility;
        }
        else return new Facility();
    }

    public void updateFacility(Facility input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Facility oldFacility = getFacility(input.getFacialityID());
        oldFacility.update(input);
        Query q = entityManager.createNativeQuery("UPDATE Placowki SET adres =?,nr_telefonu =? WHERE id_placowki=?");
        q.setParameter(1,oldFacility.getAdress());
        q.setParameter(2,oldFacility.getPhoneNumber());
        q.executeUpdate();
        if(oldFacility.getManagerID()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE Placowki SET id_kierownika=? WHERE id_placowki=?");
            qu.setParameter(1,oldFacility.getManagerID());
            qu.setParameter(2,oldFacility.getFacialityID());
            qu.executeUpdate();
        }
        entityManager.getTransaction().commit();
    }

    public void addFacility(Facility input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("INSERT INTO Placowki (id_placowki,adres,nr_telefonu) VALUES(?,?,?)");
        q.setParameter(1,input.getFacialityID());
        q.setParameter(2,input.getAdress());
        q.setParameter(3,input.getPhoneNumber());
        q.executeUpdate();
        if(input.getManagerID()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE Placowki SET id_kierownika=? WHERE id_placowki=?");
            qu.setParameter(1,input.getManagerID());
            qu.setParameter(2,input.getFacialityID());
            qu.executeUpdate();
        }
        entityManager.getTransaction().commit();
    }

    public void deleteFacility(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("DELETE FROM Placowki WHERE id_placowki=?");
        q.setParameter(1,ID);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
}