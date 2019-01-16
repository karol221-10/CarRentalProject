package com.psk_project.car_rental.controllers;

import com.psk_project.car_rental.db.Car;

import com.psk_project.car_rental.services.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/", method= RequestMethod.PUT)
    public String putCustomer(@RequestBody Car input ) {
        carService.addCar(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}" ,method=RequestMethod.PATCH)
    public String updateCustomers(@PathVariable(value="ID") int id, @RequestBody Car input) {
        input.setCarID(id);
        carService.updateCar(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.DELETE)
    public String deleteCustomers(@PathVariable(value="ID") int id) {
        carService.deleteCar(id);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.GET)
    public Car getSingleCustomer(@PathVariable(value="ID") int id) {
        return carService.getCar(id);
    }
}
