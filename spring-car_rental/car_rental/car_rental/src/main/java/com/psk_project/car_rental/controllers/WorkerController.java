package com.psk_project.car_rental.controllers;

import com.psk_project.car_rental.db.Worker;
import com.psk_project.car_rental.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
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
    @Autowired
    private WorkerService workerService;
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
    @RequestMapping(value="/", method= RequestMethod.PUT)
    @Transactional
    public String putWorker(@RequestBody Worker input ) {
        workerService.addWorker(input);
        return "OK";
    }

    @Transactional
    void insertWorkerWithQuery(Worker input) {

    }
}