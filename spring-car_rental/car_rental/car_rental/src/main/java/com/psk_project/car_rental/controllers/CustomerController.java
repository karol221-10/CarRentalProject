package com.psk_project.car_rental.controllers;

import com.psk_project.car_rental.db.Customer;
import com.psk_project.car_rental.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Customer> getCustomers() {
        return customerService.getCustomerList();
    }
    @RequestMapping(value="/", method= RequestMethod.PUT)
    public String putCustomer(@RequestBody Customer input ) {
        customerService.addCustomer(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}" ,method=RequestMethod.PATCH)
    public String updateCustomers(@PathVariable(value="ID") int id, @RequestBody Customer input) {
        input.setCustomerId(id);
        customerService.updateCustomer(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.DELETE)
    public String deleteCustomers(@PathVariable(value="ID") int id) {
        customerService.deleteCustomer(id);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.GET)
    public Customer getSingleCustomer(@PathVariable(value="ID") int id) {
        return customerService.getCustomer(id);
    }
}
