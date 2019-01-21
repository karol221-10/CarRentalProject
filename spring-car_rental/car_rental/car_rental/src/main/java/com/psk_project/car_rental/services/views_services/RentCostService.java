package com.psk_project.car_rental.services.views_services;




import com.psk_project.car_rental.db.views_db.RentCost;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentCostService {
    public List<RentCost> getRentCosts() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM VCENNIK");
        List<Object[]> rows = query.getResultList();
        List<RentCost> resultList = new ArrayList<>();
        for (Object[] object : rows) {
            RentCost rentCost = new RentCost();
            rentCost.setMark((String) object[0]);
            rentCost.setModel((String) object[1]);
            rentCost.setPriceForH(((BigDecimal) object[2]).intValue());
            rentCost.setPriceForKm(((BigDecimal) object[3]).intValue());

            resultList.add(rentCost);
        }
        return resultList;
    }
}
