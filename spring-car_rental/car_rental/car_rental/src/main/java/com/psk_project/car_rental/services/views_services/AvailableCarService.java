package com.psk_project.car_rental.services.views_services;

import com.psk_project.car_rental.db.views_db.AvailableCar;
import com.psk_project.car_rental.db.views_db.ServiceTerm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AvailableCarService {
    public List<AvailableCar> getAvailableCars() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM VCENNIK");
        List<Object[]> rows = query.getResultList();
        List<AvailableCar> resultList = new ArrayList<>();
        for(Object[] object : rows) {
            AvailableCar availableCar = new AvailableCar();
            if(object[0]==null) availableCar.setCarID(-1); else availableCar.setCarID(((BigDecimal)object[0]).intValue());
            availableCar.setMark((String)object[1]);
            availableCar.setModel((String)object[2]);
            resultList.add(availableCar);
        }
        return resultList;
    }
}