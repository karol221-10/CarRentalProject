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
    private WorkerService workerService;
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Worker> getWorkers() {
        return workerService.getWorkerList();
    }
    @RequestMapping(value="/", method= RequestMethod.PUT)
    public String putWorker(@RequestBody Worker input ) {
        workerService.addWorker(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}" ,method=RequestMethod.PATCH)
    public String updateWorker(@PathVariable(value="ID") int id, @RequestBody Worker input) {
        input.setWorkerID(id);
        workerService.updateWorker(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.DELETE)
    public String deleteWorker(@PathVariable(value="ID") int id) {
        workerService.deleteWorker(id);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.GET)
    public Worker getSingleWorker(@PathVariable(value="ID") int id) {
        return workerService.getWorker(id);
    }
}