package com.psk_project.car_rental.services;

import com.psk_project.car_rental.db.Rental;
import com.psk_project.car_rental.db.Servicing;
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
public class RentalService {
    public List<Rental> getRentalList() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM Wypozyczenia");
        List<Object[]> rows = query.getResultList();
        List<Rental> resultList = new ArrayList<Rental>();
        for(Object[] object : rows) {
            Rental rental = new Rental();
            rental.setRentalId(((BigDecimal)object[0]).intValue());
            if(object[1]==null) rental.setCarId(-1); else rental.setCarId(((BigDecimal)object[1]).intValue());
            if(object[2]==null) rental.setCustomerId(-1); else rental.setCustomerId(((BigDecimal)object[2]).intValue());
            if(object[3]==null) rental.setWorkerId(-1); else rental.setWorkerId(((BigDecimal)object[3]).intValue());
            rental.setOdometerBeforeRental((String)object[4]);
            rental.setRentalDate((Date)object[5]);
            rental.setBail(((BigDecimal)object[6]).intValue());
            if(object[7]==null) rental.setPriceListId(-1); else rental.setPriceListId(((BigDecimal)object[7]).intValue());
            resultList.add(rental);
        }
        return resultList;
    }


    public Rental getRental(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM Wypozyczenia WHERE id_wypozyczenia =?");
        query.setParameter(1,ID);
        List<Object[]> objects = query.getResultList();
        if(objects.size()==1) {
            Object[] object = objects.get(0);
            Rental rental = new Rental();
            rental.setRentalId(((BigDecimal)object[0]).intValue());
            if(object[1]==null) rental.setCarId(-1); else rental.setCarId(((BigDecimal)object[1]).intValue());
            if(object[2]==null) rental.setCustomerId(-1); else rental.setCustomerId(((BigDecimal)object[2]).intValue());
            if(object[3]==null) rental.setWorkerId(-1); else rental.setWorkerId(((BigDecimal)object[3]).intValue());
            rental.setOdometerBeforeRental((String)object[4]);
            rental.setRentalDate((Date)object[5]);
            rental.setBail(((BigDecimal)object[6]).intValue());
            if(object[7]==null) rental.setPriceListId(-1); else rental.setPriceListId(((BigDecimal)object[7]).intValue());
            return rental;
        }
        else return new Rental();
    }


    public void updateRental(Rental input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Rental oldRental = getRental(input.getRentalId());
        oldRental.update(input);
        Query q = entityManager.createNativeQuery("UPDATE Wypozyczenia SET licznik_przed_wypozyczeniem=?,data_wypozyczenia =?,KAUCJA=? WHERE id_wypozyczenia=?");
        q.setParameter(1,oldRental.getOdometerBeforeRental());
        q.setParameter(2,oldRental.getRentalDate());
        q.setParameter(3,oldRental.getBail());
        q.setParameter(4,oldRental.getRentalId());
        q.executeUpdate();

        if(oldRental.getRentalId()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE Wypozyczenia SET id_auta =? WHERE id_wypozyczenia=?");
            qu.setParameter(1,oldRental.getCarId());
            qu.setParameter(2,oldRental.getRentalId());
            qu.executeUpdate();
        }
        if(oldRental.getRentalId()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE Wypozyczenia SET id_klienta  =? WHERE id_wypozyczenia=?");
            qu.setParameter(1,oldRental.getCustomerId());
            qu.setParameter(2,oldRental.getRentalId());
            qu.executeUpdate();
        }
        if(oldRental.getRentalId()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE Wypozyczenia SET id_pracownika   =? WHERE id_wypozyczenia=?");
            qu.setParameter(1,oldRental.getWorkerId());
            qu.setParameter(2,oldRental.getRentalId());
            qu.executeUpdate();
        }
        if(oldRental.getRentalId()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE Wypozyczenia SET id_cennika    =? WHERE id_wypozyczenia=?");
            qu.setParameter(1,oldRental.getPriceListId());
            qu.setParameter(2,oldRental.getRentalId());
            qu.executeUpdate();
        }

        entityManager.getTransaction().commit();
    }

    public void addRental(Rental input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("INSERT INTO Wypozyczenia(id_wypozyczenia,licznik_przed_wypozyczeniem,data_wypozyczenia,KAUCJA) VALUES(?,?,?,?)");
        q.setParameter(1,input.getRentalId());
        q.setParameter(2,input.getOdometerBeforeRental());
        q.setParameter(3,input.getRentalDate());
        q.setParameter(4,input.getBail());
        q.executeUpdate();


        if(input.getRentalId()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE Wypozyczenia SET id_auta =? WHERE id_wypozyczenia=?");
            qu.setParameter(1,input.getCarId());
            qu.setParameter(2,input.getRentalId());
            qu.executeUpdate();
        }
        if(input.getRentalId()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE Wypozyczenia SET id_klienta  =? WHERE id_wypozyczenia=?");
            qu.setParameter(1,input.getCustomerId());
            qu.setParameter(2,input.getRentalId());
            qu.executeUpdate();
        }
        if(input.getRentalId()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE Wypozyczenia SET id_pracownika   =? WHERE id_wypozyczenia=?");
            qu.setParameter(1,input.getWorkerId());
            qu.setParameter(2,input.getRentalId());
            qu.executeUpdate();
        }
        if(input.getRentalId()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE Wypozyczenia SET id_cennika    =? WHERE id_wypozyczenia=?");
            qu.setParameter(1,input.getPriceListId());
            qu.setParameter(2,input.getRentalId());
            qu.executeUpdate();
        }


        entityManager.getTransaction().commit();
    }

    public void deleteRental(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("DELETE FROM Wypozyczenia WHERE id_wypozyczenia=?");
        q.setParameter(1,ID);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
