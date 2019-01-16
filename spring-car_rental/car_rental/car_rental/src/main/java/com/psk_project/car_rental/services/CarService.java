package com.psk_project.car_rental.services;


import com.psk_project.car_rental.db.Car;
import com.psk_project.car_rental.db.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    public List<Car> getCarList() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM samochody");
        List<Object[]> rows = query.getResultList();
        List<Car> resultList = new ArrayList<Car>();
        for(Object[] object : rows) {
            Car car = new Car();
            car.setCarID(((BigDecimal)object[0]).intValue());
            car.setRegistrationNumber((String)object[1]);
            car.setMark((String)object[2]);
            car.setModel((String)object[3]);
            car.setPriceListID(((BigDecimal)object[4]).intValue());
            car.setBodyNumber((String)object[5]);
            car.setBody((String)object[6]);
            car.setProductionDate((String)object[7]);
            car.setEnginePower(((BigDecimal)object[8]).intValue());
            car.setMileage(((BigDecimal)object[9]).intValue());
            car.setFuelType((String)object[10]);
            car.setComments((String)object[11]);
            resultList.add(car);
        }
        return resultList;
    }
}
