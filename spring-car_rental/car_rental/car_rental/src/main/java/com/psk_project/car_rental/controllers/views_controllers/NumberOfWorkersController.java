package com.psk_project.car_rental.controllers.views_controllers;


import com.psk_project.car_rental.db.views_db.NumberOfWorkers;
import com.psk_project.car_rental.services.views_services.NumberOfWorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class NumberOfWorkersController {
    @Autowired
    private NumberOfWorkersService NOWservice;

    @RequestMapping(value="/count", method= RequestMethod.GET)
    List<NumberOfWorkers> getAvaCars() {
        return NOWservice.getNumOfWorkers();
    }
}
