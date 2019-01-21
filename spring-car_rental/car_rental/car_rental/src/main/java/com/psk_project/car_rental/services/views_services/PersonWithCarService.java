package com.psk_project.car_rental.services.views_services;


import com.psk_project.car_rental.db.views_db.PersonWithCar;
import com.psk_project.car_rental.db.views_db.RentCost;
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
public class PersonWithCarService {
    public List<PersonWithCar> getPersonsWithCar() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM VKTOMAAUTO");
        List<Object[]> rows = query.getResultList();
        List<PersonWithCar> resultList = new ArrayList<>();
        for (Object[] object : rows) {
            PersonWithCar personWithCar = new PersonWithCar();
            personWithCar.setCustomerId(((BigDecimal) object[0]).intValue());
            personWithCar.setName((String) object[1]);
            personWithCar.setSurname((String) object[2]);
            personWithCar.setPesel((String) object[3]);
            if(object[4]==null) personWithCar.setCarId(-1); else personWithCar.setCarId(((BigDecimal)object[4]).intValue());
            personWithCar.setDate((Date) object[5]);
            resultList.add(personWithCar);
        }
        return resultList;
    }
}
