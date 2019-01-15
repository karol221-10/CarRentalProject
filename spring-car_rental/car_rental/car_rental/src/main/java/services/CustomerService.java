package services;

import com.psk_project.car_rental.db.Customer;
import com.psk_project.car_rental.repositories.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public List<Customer> getAllUsers() {
        return this.customerDao.findAll();
    }

    public Customer addUser(Customer customer) {
        return this.customerDao.save(customer);
    }
}
