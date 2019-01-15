package com.psk_project.car_rental;

import com.psk_project.car_rental.db_connection.JdbcOracleConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.psk_project.car_rental.controllers.CustomerController"})

public class CarRentalApplication {

	public static void main(String[] args) {
		JdbcOracleConnection jdbcOracleConnection = new JdbcOracleConnection();
		SpringApplication.run(CarRentalApplication.class, args);

	}
}

