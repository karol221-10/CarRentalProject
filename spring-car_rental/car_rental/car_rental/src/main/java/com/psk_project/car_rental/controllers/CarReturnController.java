package com.psk_project.car_rental.controllers;
import com.psk_project.car_rental.db.CarReturn;
import com.psk_project.car_rental.services.CarReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carReturn")
public class CarReturnController {

    @Autowired
    private CarReturnService carReturnService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    List<CarReturn> getCarReturnsList() {
        return carReturnService.getList();
    }

    @RequestMapping(value="/", method= RequestMethod.PUT)
    public String putCarReturn(@RequestBody CarReturn input ) {
        carReturnService.add(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}" ,method=RequestMethod.PATCH)
    public String updateCarReturn(@PathVariable(value="ID") int id, @RequestBody CarReturn input) {
        input.setReturnID(id);
        carReturnService.update(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.DELETE)
    public String deleteCarReturn(@PathVariable(value="ID") int id) {
        carReturnService.delete(id);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.GET)
    public CarReturn getSingleCarReturn(@PathVariable(value="ID") int id) {
        return carReturnService.get(id);
    }
}
