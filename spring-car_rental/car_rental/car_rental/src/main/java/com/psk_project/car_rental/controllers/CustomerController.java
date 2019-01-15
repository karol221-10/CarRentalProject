package com.psk_project.car_rental.controllers;

import com.psk_project.car_rental.db.Worker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public List<Worker> hello() {
        System.out.println("Hit me!");
        List<Worker> works = new ArrayList<Worker>();
        return works;
    }
}