package com.psk_project.car_rental.controllers.procedure_controllers;


import com.psk_project.car_rental.services.procedure_service.AdditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@RequestMapping(value = "/addition")
public class AdditionController {

    @Autowired
    AdditionService additionService;

    @RequestMapping(value = "/")
    public String  execAddition(){
        additionService.addition(10);
        return "OK";
    }
}