package com.psk_project.car_rental.controllers.procedure_controllers;

import com.psk_project.car_rental.services.procedure_service.PayRiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/payrise")
public class PayRaiseController {

    @Autowired
    PayRiseService payRiseService;

    @RequestMapping(value = "/" ,method= RequestMethod.GET)
    public String payRiseForPoorestWorkers(){
        payRiseService.payRaiseForPoorestWorkers();
        return "OK";
    }
}
