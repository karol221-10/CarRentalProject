package com.psk_project.car_rental;

import com.psk_project.car_rental.db.Worker;
import com.psk_project.car_rental.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CarRentalApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CarRentalApplication.class, args);
	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction().commit();
		List<Worker> work = session.createQuery("FROM Worker").list();
		System.out.println("Worker id: "+work.get(0).getName());
	}

}

