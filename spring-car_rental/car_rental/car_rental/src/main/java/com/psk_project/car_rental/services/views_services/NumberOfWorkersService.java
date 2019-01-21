package com.psk_project.car_rental.services.views_services;

import com.psk_project.car_rental.db.views_db.AvailableCar;
import com.psk_project.car_rental.db.views_db.NumberOfWorkers;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class NumberOfWorkersService {

        public List<NumberOfWorkers> getNumOfWorkers() {
            EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
            EntityManager entityManager = fact.createEntityManager();
            Query query = entityManager.createNativeQuery("SELECT * FROM VILOSCPRACOWNIKOWPLACOWKI");
            List<Object[]> rows = query.getResultList();
            List<NumberOfWorkers> resultList = new ArrayList<>();
            for(Object[] object : rows) {
                NumberOfWorkers numOfWorkers = new NumberOfWorkers();
                numOfWorkers.setNumberOFWorkers((String)object[0]);
                numOfWorkers.setAdres((String)object[1]);
                resultList.add(numOfWorkers);
            }
            return resultList;
        }
    }

