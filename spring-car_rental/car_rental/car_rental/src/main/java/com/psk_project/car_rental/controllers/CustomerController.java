package com.psk_project.car_rental;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello() {
        System.out.println("Hit me!");
        return "Hello you";
    }

}