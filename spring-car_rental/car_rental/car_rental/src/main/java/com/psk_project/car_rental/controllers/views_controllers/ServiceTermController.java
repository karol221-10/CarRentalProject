package com.psk_project.car_rental.controllers.views_controllers;


import com.psk_project.car_rental.db.views_db.ServiceTerm;
import com.psk_project.car_rental.services.views_services.ServiceTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class ServiceTermController {

    @Autowired
    private ServiceTermService serviceTermService;

    @RequestMapping(value="/service-expiration", method= RequestMethod.GET)
    List<ServiceTerm> getServiceExpirTerm() {
       return serviceTermService.getServiceExpirationTerm();
    }
}
