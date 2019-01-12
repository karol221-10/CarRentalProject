package com.psk_project.car_rental.repository;

import com.psk_project.car_rental.model.ModelExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface ModelExampleRepo extends JpaRepository<ModelExample, Long> {
    ModelExample findByName(String name);
}