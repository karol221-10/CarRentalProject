package com.psk_project.car_rental.controllers;

import com.psk_project.car_rental.db.Car;
import com.psk_project.car_rental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    List<Car> getCarList() {
        return carService.getCarList();
    }
}
