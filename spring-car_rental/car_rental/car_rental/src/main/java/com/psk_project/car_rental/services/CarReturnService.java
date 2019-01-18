package com.psk_project.car_rental.services;
import com.psk_project.car_rental.db.CarReturn;
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
public class CarReturnService {
    private CarReturn createCarReturn(Object[] object) {
        CarReturn carret = new CarReturn();
        carret.setReturnID(((BigDecimal)object[0]).intValue());
        carret.setRentalID(((BigDecimal)object[1]).intValue());
        carret.setWorkerID(((BigDecimal)object[2]).intValue());
        carret.setDate((Date)object[3]);
        return carret;
    }
    public List<CarReturn> getList() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM zwroty");
        List<Object[]> rows = query.getResultList();
        List<CarReturn> resultList = new ArrayList<>();
        for(Object[] object : rows) {
            resultList.add(createCarReturn(object));
        }
        return resultList;
    }
    public CarReturn get(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM zwroty WHERE id_zwrotu=?");
        query.setParameter(1,ID);
        List<Object[]> objects = query.getResultList();
        if(objects.size()==1) {
            Object[] object = objects.get(0);
            return createCarReturn(object);
        }
        else return new CarReturn();
    }

    public void update(CarReturn input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        CarReturn oldCarReturn = get(input.getReturnID());
        oldCarReturn.update(input);
        Query q = entityManager.createNativeQuery("UPDATE zwroty SET id_wypozyczenia=? id_pracownika=? data_zwrotu=?  WHERE id_zwrotu=?");
        q.setParameter(1,oldCarReturn.getRentalID());
        q.setParameter(2,oldCarReturn.getWorkerID());
        q.setParameter(3,oldCarReturn.getDate());
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public void add(CarReturn input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("INSERT INTO zwroty VALUES(?,?,?,?)");
        q.setParameter(1,input.getReturnID());
        q.setParameter(2,input.getRentalID());
        q.setParameter(3,input.getWorkerID());
        q.setParameter(4,input.getDate());
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
    public void delete(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("DELETE FROM zwroty WHERE id_zwrotu=?");
        q.setParameter(1,ID);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
