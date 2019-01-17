package com.psk_project.car_rental.controllers;

import com.psk_project.car_rental.db.Rental;
import com.psk_project.car_rental.services.RentalService;
import com.psk_project.car_rental.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {
    @Autowired
    private RentalService rentalService;
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Rental> getRentals() {
        return rentalService.getRentalList();
    }
    @RequestMapping(value="/", method= RequestMethod.PUT)
    public String putRental(@RequestBody Rental input ) {
        rentalService.addRental(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}" ,method=RequestMethod.PATCH)
    public String updateRental(@PathVariable(value="ID") int id, @RequestBody Rental input) {
        input.setRentalId(id);
        rentalService.updateRental(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.DELETE)
    public String deleteRental(@PathVariable(value="ID") int id) {
        rentalService.deleteRental(id);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.GET)
    public Rental getSingleRental(@PathVariable(value="ID") int id) {
        return rentalService.getRental(id);
    }
}