package com.psk_project.car_rental.services.views_services;


import com.psk_project.car_rental.db.views_db.ServiceTerm;
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
public class ServiceTermService {

    public List<ServiceTerm> getServiceExpirationTerm() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM VTERMINPRZEGLADU");
        List<Object[]> rows = query.getResultList();
        List<ServiceTerm> resultList = new ArrayList<>();
        for(Object[] object : rows) {
            ServiceTerm serviceTerm = new ServiceTerm();
            if(object[0]==null) serviceTerm.setCarID(-1); else serviceTerm.setCarID(((BigDecimal)object[0]).intValue());
            if(object[1]==null) serviceTerm.setServiceId(-1); else serviceTerm.setServiceId(((BigDecimal)object[1]).intValue());
            serviceTerm.setMark((String)object[2]);
            serviceTerm.setModel((String)object[3]);
            serviceTerm.setExpirationDate((Date)object[4]);
            resultList.add(serviceTerm);
        }
        return resultList;
    }
}
