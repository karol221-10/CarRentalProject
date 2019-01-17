package com.psk_project.car_rental.controllers;


import com.psk_project.car_rental.db.Servicing;

import com.psk_project.car_rental.services.ServicingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/servicing")
public class ServicingController {

        @Autowired
        private ServicingService servicingService;

        @RequestMapping(value="/", method= RequestMethod.GET)
        List<Servicing> getCarList() {
            return servicingService.getServicingList();
        }

        @RequestMapping(value="/", method= RequestMethod.PUT)
        public String putCustomer(@RequestBody Servicing input ) {
            servicingService.addServicing(input);
            return "OK";
        }
        @RequestMapping(value="/{ID}" ,method=RequestMethod.PATCH)
        public String updateCustomers(@PathVariable(value="ID") int id, @RequestBody Servicing input) {
            input.setOverviewID(id);
            servicingService.updateServicing(input);
            return "OK";
        }
        @RequestMapping(value="/{ID}",method=RequestMethod.DELETE)
        public String deleteCustomers(@PathVariable(value="ID") int id) {
            servicingService.deleteServicing(id);
            return "OK";
        }
        @RequestMapping(value="/{ID}",method=RequestMethod.GET)
        public Servicing getSingleCustomer(@PathVariable(value="ID") int id) {
            return servicingService.getServicing(id);
        }

}
