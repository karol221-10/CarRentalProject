package com.psk_project.car_rental.controllers.views_controllers;


import com.psk_project.car_rental.db.views_db.PersonWithCar;
import com.psk_project.car_rental.services.views_services.PersonWithCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rented")
public class PersonWithCarController {
    @Autowired
    private PersonWithCarService personWithCarService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    List<PersonWithCar> getPersonWithCar() { return personWithCarService.getPersonsWithCar(); }
}

