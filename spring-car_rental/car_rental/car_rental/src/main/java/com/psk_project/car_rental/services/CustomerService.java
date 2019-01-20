package com.psk_project.car_rental.services;

import com.psk_project.car_rental.db.Customer;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerService {

    public List<Customer> getCustomerList() {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM klient");
        List<Object[]> rows = query.getResultList();
        List<Customer> resultList = new ArrayList<Customer>();
        for(Object[] object : rows) {
            Customer customer = new Customer();
            customer.setCustomerId(((BigDecimal)object[0]).intValue());
            customer.setName((String)object[1]);
            customer.setSurname((String)object[2]);
            customer.setPesel((String)object[3]);
            customer.setPhone((String)object[4]);
            customer.setDocumentType((String)object[5]);
            customer.setIdNumber((String)object[6]);
            customer.setPlace((String)object[7]);
            customer.setAddress((String)object[8]);
            customer.setPostal((String)object[9]);
            customer.setPostOffice((String)object[10]);
            customer.setRemarks((String)object[11]);
            resultList.add(customer);
        }
        return resultList;
    }
    public Customer getCustomer(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM klient WHERE id_klienta=?");
        query.setParameter(1,ID);
        List<Object[]> objects = query.getResultList();
        if(objects.size()==1) {
            Object[] object = objects.get(0);
            Customer customer = new Customer();
            customer.setCustomerId(((BigDecimal)object[0]).intValue());
            customer.setName((String)object[1]);
            customer.setSurname((String)object[2]);
            customer.setPesel((String)object[3]);
            customer.setPhone((String)object[4]);
            customer.setDocumentType((String)object[5]);
            customer.setIdNumber((String)object[6]);
            customer.setPlace((String)object[7]);
            customer.setAddress((String)object[8]);
            customer.setPostal((String)object[9]);
            customer.setPostOffice((String)object[10]);
            customer.setRemarks((String)object[11]);
            return customer;
        }
        else return new Customer();
    }

    public void updateCustomer(Customer input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Customer oldCustomer = getCustomer(input.getCustomerId());
        oldCustomer.update(input);
        Query q = entityManager.createNativeQuery("UPDATE klient SET imie=?,nazwisko=?,pesel=?,nr_telefonu=?,rodzaj_dokumentu=?,nr_dowodu=?,miejscowosc=?,adres=?,kod_pocztowy=?,poczta=?, uwagi=?  WHERE id_klienta=?");
        q.setParameter(1,oldCustomer.getName());
        q.setParameter(2,oldCustomer.getSurname());
        q.setParameter(3,oldCustomer.getPesel());
        q.setParameter(4,oldCustomer.getPhone());
        q.setParameter(5,oldCustomer.getIdNumber());
        q.setParameter(6,oldCustomer.getDocumentType());
        q.setParameter(7,oldCustomer.getPlace());
        q.setParameter(8,oldCustomer.getAddress());
        q.setParameter(9,oldCustomer.getPostal());
        q.setParameter(10,oldCustomer.getPostOffice());
        q.setParameter(11,oldCustomer.getRemarks());
        q.setParameter(12,oldCustomer.getCustomerId());
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
    public void addCustomer(Customer input) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("INSERT INTO klient(id_klienta, imie, nazwisko, pesel, nr_telefonu, rodzaj_dokumentu, nr_dowodu, miejscowosc, adres, kod_pocztowy, poczta, uwagi) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        q.setParameter(1,input.getCustomerId());
        q.setParameter(2,input.getName());
        q.setParameter(3,input.getSurname());
        q.setParameter(4,input.getPesel());
        q.setParameter(5,input.getPhone());
        q.setParameter(6,input.getDocumentType());
        q.setParameter(7,input.getIdNumber());
        q.setParameter(8,input.getPlace());
        q.setParameter(9,input.getAddress());
        q.setParameter(10,input.getPostal());
        q.setParameter(11,input.getPostOffice());
        q.setParameter(12,input.getRemarks());

        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
    public void deleteCustomer(int ID) {
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("JPAService");
        EntityManager entityManager = fact.createEntityManager();
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("DELETE FROM klient WHERE id_klienta=?");
        q.setParameter(1,ID);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
