package com.psk_project.car_rental.controllers.procedure_controllers;

import com.psk_project.car_rental.services.procedure_service.HollydayDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hollyday-discount")
public class HollydayDiscountController {

    @Autowired
    HollydayDiscountService hollydayDiscountService;

    @RequestMapping(value = "/" ,method= RequestMethod.GET)
    public String hollydaydsc(){
        hollydayDiscountService.hollydayDisc();
        return "OK";
    }
}
