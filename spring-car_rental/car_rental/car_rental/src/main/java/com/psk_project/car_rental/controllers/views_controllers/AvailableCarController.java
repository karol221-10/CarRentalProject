package com.psk_project.car_rental.controllers.views_controllers;

import com.psk_project.car_rental.db.views_db.AvailableCar;
import com.psk_project.car_rental.services.views_services.AvailableCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class AvailableCarController {
    @Autowired
    private AvailableCarService availableCarService;

    @RequestMapping(value="/available", method= RequestMethod.GET)
    List<AvailableCar> getAvaCars() {
        return availableCarService.getAvailableCars();
    }
}
