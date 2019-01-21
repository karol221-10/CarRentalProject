package com.psk_project.car_rental.services.procedure_service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Service
public class PayRiseService {
    public void payRaiseForPoorestWorkers(){
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("EXECUTE PROCEDURE pZaMalo();");
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
