package com.psk_project.car_rental.controllers;

import com.psk_project.car_rental.db.Car;
import com.psk_project.car_rental.db.Insurance;
import com.psk_project.car_rental.services.CarService;
import com.psk_project.car_rental.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    List<Insurance> getInsuranceList() {
        return insuranceService.getList();
    }

    @RequestMapping(value="/", method= RequestMethod.PUT)
    public String putInsurance(@RequestBody Insurance input ) {
        insuranceService.add(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}" ,method=RequestMethod.PATCH)
    public String updateInsurance(@PathVariable(value="ID") int id, @RequestBody Insurance input) {
        input.setInsuranceID(id);
        insuranceService.update(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.DELETE)
    public String deleteInsurance(@PathVariable(value="ID") int id) {
        insuranceService.delete(id);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.GET)
    public Insurance getSingleCustomer(@PathVariable(value="ID") int id) {
        return insuranceService.get(id);
    }
}
