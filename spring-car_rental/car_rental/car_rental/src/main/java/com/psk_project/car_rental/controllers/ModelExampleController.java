package com.psk_project.car_rental.controllers;

import com.psk_project.car_rental.model.ModelExample;
import com.psk_project.car_rental.repository.ModelExampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class ModelExampleController {

    @Autowired
    private ModelExampleRepo modelExampleRepo;

    @GetMapping(value = "/all")
    public List<ModelExample> findAll(){
        return modelExampleRepo.findAll();
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

}
