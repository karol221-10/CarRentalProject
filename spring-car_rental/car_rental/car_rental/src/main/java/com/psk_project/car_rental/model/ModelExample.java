package com.psk_project.car_rental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ModelExample {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public ModelExample() {
    }

    public ModelExample(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ModelExample(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
