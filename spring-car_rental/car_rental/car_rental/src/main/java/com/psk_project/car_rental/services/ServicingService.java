package com.psk_project.car_rental.services;

import com.psk_project.car_rental.db.Servicing;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicingService {

        public List<Servicing> getServicingList() {
            EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
            EntityManager entityManager = fact.createEntityManager();
            Query query = entityManager.createNativeQuery("SELECT * FROM Przeglady");
            List<Object[]> rows = query.getResultList();
            List<Servicing> resultList = new ArrayList<Servicing>();
            for(Object[] object : rows) {
                Servicing servicing= new Servicing();
                servicing.setOverviewID(((BigDecimal)object[0]).intValue());
                servicing.setCarID((Integer) object[1]);
                servicing.setOverviewType((String) object[2]);
                servicing.setExpirationDate((Integer) object[3]);
                servicing.setExecutionDate((Integer) object[4]);
                servicing.setPrice((Integer) object[5]);
                servicing.setComments((String) object[6]);
                resultList.add(servicing);
            }
            return resultList;
        }

        public Servicing getServicing(int ID) {
            EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
            EntityManager entityManager = fact.createEntityManager();
            Query query = entityManager.createNativeQuery("SELECT * FROM Przeglady WHERE id_przegladu =?");
            query.setParameter(1,ID);
            List<Object[]> objects = query.getResultList();
            if(objects.size()==1) {
                Object[] object = objects.get(0);
                Servicing servicing= new Servicing();
                servicing.setOverviewID(((BigDecimal)object[0]).intValue());
                servicing.setCarID((Integer) object[1]);
                servicing.setOverviewType((String) object[2]);
                servicing.setExpirationDate((Integer) object[3]);
                servicing.setExecutionDate((Integer) object[4]);
                servicing.setPrice((Integer) object[5]);
                servicing.setComments((String) object[6]);
                return servicing;
            }
            else return new Servicing();
        }

    public void updateServicing(Servicing input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Servicing oldServicing= getServicing(input.getOverviewID());
        oldServicing.update(input);
        Query q = entityManager.createNativeQuery("UPDATE Przeglady SET id_auta =?,rodzaj_przegladu  =?,data_waznosci_przegladu =?,data_wykonania_przegladu =?,koszt_przegladu =?,uwagi =?");
        q.setParameter(1,oldServicing.getOverviewID());
        q.setParameter(2,oldServicing.getCarID());
        q.setParameter(3,oldServicing.getOverviewType());
        q.setParameter(4,oldServicing.getExpirationDate());
        q.setParameter(5,oldServicing.getExecutionDate());
        q.setParameter(6,oldServicing.getPrice());
        q.setParameter(7,oldServicing.getComments());
        q.executeUpdate();
        if(oldServicing.getCarID()!=-1) {
            Query qu = entityManager.createNativeQuery("UPDATE Przeglady SET id_auta=? WHERE id_przegladu=?");
            qu.setParameter(1,oldServicing.getCarID());
            qu.setParameter(2,oldServicing.getOverviewID());
            qu.executeUpdate();
        }
        entityManager.getTransaction().commit();
    }

        public void addServicing(Servicing input) {
            EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
            EntityManager entityManager = fact.createEntityManager();
            entityManager.getTransaction().begin();
            Query q = entityManager.createNativeQuery("INSERT INTO Przeglady(id_przegladu,id_auta,rodzaj_przegladu ,data_waznosci_przegladu ,data_wykonania_przegladu ,koszt_przegladu ,uwagi) VALUES(?,?,?,?,?,?,?,?)");
            q.setParameter(1,input.getOverviewID());
            q.setParameter(2,input.getCarID());
            q.setParameter(3,input.getOverviewType());
            q.setParameter(4,input.getExpirationDate());
            q.setParameter(5,input.getExecutionDate());
            q.setParameter(6,input.getPrice());
            q.setParameter(7,input.getComments());
            q.executeUpdate();
            if(input.getCarID()!=-1) {
                Query qu = entityManager.createNativeQuery("UPDATE Przeglady SET id_auta=? WHERE id_przegladu=?");
                qu.setParameter(1,input.getCarID());
                qu.setParameter(2,input.getOverviewID());
                qu.executeUpdate();
            }
            entityManager.getTransaction().commit();
        }
        public void deleteServicing(int ID) {
            EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
            EntityManager entityManager = fact.createEntityManager();
            entityManager.getTransaction().begin();
            Query q = entityManager.createNativeQuery("DELETE FROM Przeglady WHERE id_przegladu=?");
            q.setParameter(1,ID);
            q.executeUpdate();
            entityManager.getTransaction().commit();
        }
}


