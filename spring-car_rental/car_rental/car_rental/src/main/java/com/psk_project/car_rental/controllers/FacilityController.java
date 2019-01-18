package com.psk_project.car_rental.controllers;


import com.psk_project.car_rental.db.Facility;
import com.psk_project.car_rental.services.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private FacilityService facilityService;
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Facility> getFacility() {
        return facilityService.getFacilityList();
    }
    @RequestMapping(value="/", method= RequestMethod.PUT)
    public String putFacility(@RequestBody Facility input ) {
        facilityService.addFacility(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}" ,method=RequestMethod.PATCH)
    public String updateFacility(@PathVariable(value="ID") int id, @RequestBody Facility input) {
        input.setFacialityID(id);
        facilityService.updateFacility(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.DELETE)
    public String deleteFacility(@PathVariable(value="ID") int id) {
        facilityService.deleteFacility(id);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.GET)
    public Facility getSingleFacility(@PathVariable(value="ID") int id) {
        return facilityService.getFacility(id);
    }
}