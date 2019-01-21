package com.psk_project.car_rental;

import com.psk_project.car_rental.db_connection.JdbcOracleConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@SpringBootApplication
public class CarRentalApplication {

	public static void main(String[] args) {
		JdbcOracleConnection.init();
		SpringApplication.run(CarRentalApplication.class, args);

	}
}

