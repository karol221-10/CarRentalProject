package com.psk_project.car_rental.services;

import com.psk_project.car_rental.db.PriceList;
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
public class PriceListService {
    public List<PriceList> getPriceListList() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM Cennik");
        List<Object[]> rows = query.getResultList();
        List<PriceList> resultList = new ArrayList<PriceList>();
        for(Object[] object : rows) {
            PriceList priceList = new PriceList();
            priceList.setPriceListID(((BigDecimal)object[0]).intValue());
            priceList.setPriceForH(((BigDecimal) object[1]).intValue());
            priceList.setPriceForKm(((BigDecimal)object[2]).intValue());
            priceList.setChangeDate((Date) object[3]);
            resultList.add(priceList);
        }
        return resultList;
    }
    public PriceList getPriceList(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM Cennik WHERE id_cennika=?");
        query.setParameter(1,ID);
        List<Object[]> objects = query.getResultList();
        if(objects.size()==1) {
            Object[] object = objects.get(0);
            PriceList priceList = new PriceList();
            priceList.setPriceListID(((BigDecimal)object[0]).intValue());
            priceList.setPriceForH(((BigDecimal) object[1]).intValue());
            priceList.setPriceForKm(((BigDecimal)object[2]).intValue());
            priceList.setChangeDate((Date) object[3]);
            return priceList;
        }
        else return new PriceList();
    }

    public void updatePriceList(PriceList input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        PriceList oldPriceList = getPriceList(input.getPriceListID());
        oldPriceList.update(input);
        Query q = entityManager.createNativeQuery("UPDATE Cennik SET cena_h_wyp=?,cena_za_km=?,data_zmiany=? WHERE id_cennika=?");
        q.setParameter(1,oldPriceList.getPriceForH());
        q.setParameter(2,oldPriceList.getPriceForKm());
        q.setParameter(3,oldPriceList.getChangeDate());
        q.setParameter(4,oldPriceList.getPriceListID());
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }


    public void addPriceList(PriceList input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("INSERT INTO Cennik(id_cennika,cena_h_wyp,cena_za_km,data_zmiany) VALUES(?,?,?,?,?)");
        q.setParameter(1,input.getPriceListID());
        q.setParameter(2,input.getPriceForH());
        q.setParameter(3,input.getPriceForKm());
        q.setParameter(4,input.getChangeDate());
        q.executeUpdate();

        entityManager.getTransaction().commit();
    }
    public void deletePriceList(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("DELETE FROM Cennik WHERE id_cennika=?");
        q.setParameter(1,ID);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
