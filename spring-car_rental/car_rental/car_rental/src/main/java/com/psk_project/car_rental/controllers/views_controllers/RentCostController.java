package com.psk_project.car_rental.controllers.views_controllers;

import com.psk_project.car_rental.db.views_db.AvailableCar;
import com.psk_project.car_rental.db.views_db.RentCost;
import com.psk_project.car_rental.services.views_services.AvailableCarService;
import com.psk_project.car_rental.services.views_services.RentCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pricelist")
public class RentCostController {
    @Autowired
    private RentCostService rentCostService;

    @RequestMapping(value="/cost", method= RequestMethod.GET)
    List<RentCost> getRentCost() {
        return rentCostService.getRentCosts();
    }
}
