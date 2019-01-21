package com.psk_project.car_rental.services.views_services;

import com.psk_project.car_rental.db.views_db.WhoRented;
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
public class WhoRentedService {
    public List<WhoRented> getWhoRented() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM VKTOWYPOZYCZYL");
        List<Object[]> rows = query.getResultList();
        List<WhoRented> resultList = new ArrayList<>();
        for (Object[] object : rows) {
            WhoRented whoRented = new WhoRented();
            if (object[0] == null) whoRented.setCustomerId(-1);
            else whoRented.setCustomerId(((BigDecimal) object[0]).intValue());
            whoRented.setName((String) object[1]);
            whoRented.setSurmane((String) object[2]);
            if (object[3] == null) whoRented.setRentID(-1);
            else whoRented.setRentID(((BigDecimal) object[3]).intValue());
            whoRented.setRentDate((Date) (object[4]));
            resultList.add(whoRented);
        }
        return resultList;
    }
}

