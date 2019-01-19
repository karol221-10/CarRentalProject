package com.psk_project.car_rental.services;


import com.psk_project.car_rental.db.Car;
import com.psk_project.car_rental.db.Customer;
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
            if(object[4]==null) car.setPriceListID(-1); else car.setPriceListID(((BigDecimal)object[4]).intValue());
            car.setBodyNumber((String)object[5]);
            car.setBody((String)object[6]);
            car.setProductionDate((Date)object[7]);
            car.setEnginePower(((BigDecimal)object[8]).intValue());
            car.setMileage(((BigDecimal)object[9]).intValue());
            car.setFuelType((String)object[10]);
            car.setComments((String)object[11]);
            resultList.add(car);
        }
        return resultList;
    }
    public Car getCar(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM samochody WHERE id_auta=?");
        query.setParameter(1,ID);
        List<Object[]> objects = query.getResultList();
        if(objects.size()==1) {
            Object[] object = objects.get(0);
            Car car = new Car();
            car.setCarID(((BigDecimal)object[0]).intValue());
            car.setRegistrationNumber((String)object[1]);
            car.setMark((String)object[2]);
            car.setModel((String)object[3]);
            if(object[4]==null) car.setPriceListID(-1); else car.setPriceListID(((BigDecimal)object[4]).intValue());
            car.setBodyNumber((String)object[5]);
            car.setBody((String)object[6]);
            car.setProductionDate((Date)object[7]);
            car.setEnginePower(((BigDecimal)object[8]).intValue());
            car.setMileage(((BigDecimal)object[9]).intValue());
            car.setFuelType((String)object[10]);
            car.setComments((String)object[11]);
            return car;
        }
        else return new Car();
    }

    public void updateCar(Car input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Car oldCar = getCar(input.getCarID());
        oldCar.update(input);
        Query q = entityManager.createNativeQuery("UPDATE samochody SET numer_rejestracyjny=?,marka=?,m_model=?,numer_nadwozia=?,typ_nadwozia=?,data_produkcji=?,moc_silnika=?,przebieg_auta=?,rodzaj_paliwa=?, uwagi=?  WHERE id_auta=?");
        q.setParameter(1,oldCar.getRegistrationNumber());
        q.setParameter(2,oldCar.getMark());
        q.setParameter(3,oldCar.getModel());
        q.setParameter(4,oldCar.getBodyNumber());
        q.setParameter(5,oldCar.getBody());
        q.setParameter(6,oldCar.getProductionDate());
        q.setParameter(7,oldCar.getEnginePower());
        q.setParameter(8,oldCar.getMileage());
        q.setParameter(9,oldCar.getFuelType());
        q.setParameter(10,oldCar.getComments());
        q.executeUpdate();
        if(oldCar.getPriceListID()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE samochody SET id_cennika=? WHERE id_auta=?");
            qu.setParameter(1,oldCar.getPriceListID());
            qu.setParameter(2,oldCar.getCarID());
            qu.executeUpdate();
        }
        entityManager.getTransaction().commit();
    }

    public void addCar(Car input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("INSERT INTO samochody(id_auta,numer_rejestracyjny,marka,m_model,numer_nadwozia,typ_nadwozia,data_produkcji,moc_silnika,przebieg_auta,rodzaj_paliwa, uwagi) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        q.setParameter(1,input.getCarID());
        q.setParameter(2,input.getRegistrationNumber());
        q.setParameter(3,input.getMark());
        q.setParameter(4,input.getModel());
        q.setParameter(5,input.getBodyNumber());
        q.setParameter(6,input.getBody());
        q.setParameter(7,input.getProductionDate());
        q.setParameter(8,input.getEnginePower());
        q.setParameter(9,input.getMileage());
        q.setParameter(10,input.getFuelType());
        q.setParameter(11,input.getComments());
        q.executeUpdate();

        if(input.getPriceListID()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE samochody SET id_cennika=? WHERE id_auta=?");
            qu.setParameter(1,input.getPriceListID());
            qu.setParameter(2,input.getCarID());
            qu.executeUpdate();
        }
        entityManager.getTransaction().commit();
    }
    public void deleteCar(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("DELETE FROM samochody WHERE id_auta=?");
        q.setParameter(1,ID);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
