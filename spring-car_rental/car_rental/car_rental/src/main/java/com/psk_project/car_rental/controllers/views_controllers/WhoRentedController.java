package com.psk_project.car_rental.controllers.views_controllers;

import com.psk_project.car_rental.db.views_db.ServiceTerm;
import com.psk_project.car_rental.db.views_db.WhoRented;
import com.psk_project.car_rental.services.views_services.WhoRentedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whorentend")
public class WhoRentedController {
    @Autowired
    private WhoRentedService whoRentedService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    List<WhoRented> getServiceExpirTerm() {
        return whoRentedService.getWhoRented();
    }
}
