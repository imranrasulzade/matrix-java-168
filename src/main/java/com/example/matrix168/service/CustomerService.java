package com.example.matrix168.service;

import com.example.matrix168.model.Customer;
import com.example.matrix168.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    public boolean update(Integer id, Customer updatedCustomer) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            updatedCustomer.setId(id);
            customerRepository.save(updatedCustomer);
            return true;
        }
        return false;
    }

    public boolean delete(Integer id) {
        return customerRepository.deleteById(id);
    }


}
