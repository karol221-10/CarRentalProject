package com.psk_project.car_rental.controllers;

import com.psk_project.car_rental.db.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private EntityManager entityManager;
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Worker> getWorkers() {
        Query query = entityManager.createNativeQuery("SELECT * FROM pracownik");
        List<Object[]> rows = query.getResultList();
        List<Worker> resultList = new ArrayList<Worker>();
        for(Object[] object : rows) {
            Worker worker = new Worker();
            worker.setWorkerID(((BigDecimal)object[0]).intValue());
            worker.setName((String)object[1]);
            worker.setSurname((String)object[2]);
            worker.setPesel((String)object[3]);
            worker.setPhone((String)object[4]);
            worker.setSex((String)object[5]);
            worker.setCity((String)object[6]);
            worker.setAddress((String)object[7]);
            worker.setPostal((String)object[8]);
            worker.setPostOffice((String)object[9]);
            if(object[10]==null) worker.setRentalID(-1);
            else worker.setRentalID(((BigDecimal)object[10]).intValue());
      //      worker.setSalary(((BigDecimal)object[11]).intValue());
            resultList.add(worker);
        }
        return resultList;
    }
    @Transactional
    @RequestMapping(value="/", method= RequestMethod.PUT)
    public String putWorker(@RequestBody Worker input ) {
        String sql = "INSERT INTO pracownik VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        Query qu = entityManager.createNativeQuery(sql);
        qu.setParameter(1,input.getWorkerID());
        qu.setParameter(2,input.getName());
        qu.setParameter(3,input.getSurname());
        qu.setParameter(4,input.getPesel());
        qu.setParameter(5,input.getPhone());
        qu.setParameter(6,input.getSex());
        qu.setParameter(7,input.getCity());
        qu.setParameter(8,input.getAddress());
        qu.setParameter(9,input.getPostal());
        qu.setParameter(10,input.getPostOffice());
        if(input.getRentalID()==-1) qu.setParameter(11,null);
        else qu.setParameter(11,input.getRentalID());
        qu.setParameter(12,input.getSalary());
        String res;
        try
        {
            qu.executeUpdate();
            return "OK";
        }
        catch(Exception e ) {
            return "error";
        }
    }
}