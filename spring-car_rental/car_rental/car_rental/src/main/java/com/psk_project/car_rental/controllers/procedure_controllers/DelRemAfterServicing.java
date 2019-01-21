package com.psk_project.car_rental.controllers.procedure_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/after-service")
public class DelRemAfterServicing {

    @Autowired
     DelRemAfterServicing DRASservice;

    @RequestMapping(value ="/"  ,method= RequestMethod.GET)
    public String delRemAfterServicing(){
        DRASservice.delRemAfterServicing();
        return "OK";
    }
}
