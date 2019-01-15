package com.psk_project.car_rental.controllers;

import com.psk_project.car_rental.db.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import services.CustomerService;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Customer> getAllUsers() {
        return customerService.getAllUsers();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
   public String greetings(){
        return "hellollllllll";
    }

    @RequestMapping(value = "/addcustomer", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Customer addNewUser(@RequestBody Customer customer) {
        return this.customerService.addUser(customer);
    }
}
