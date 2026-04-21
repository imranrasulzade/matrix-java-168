package com.example.matrix168.repository;

import com.example.matrix168.model.Customer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {


    private final List<Customer> customers = new ArrayList<>();

    @PostConstruct
    public void init() {
        customers.add(new Customer("Sabir","Huseynov", 24, 1));
        System.out.println("CustomerRepository init method called");
    }

    public List<Customer> findAll() {
        return  new ArrayList<>(customers);
    }

    public Optional<Customer> findById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public Customer save(Customer customer) {
        this.findById(customer.getId()).ifPresentOrElse(
                existing -> {
                    existing.setName(customer.getName());
                    existing.setSurname(customer.getSurname());
                    existing.setAge(customer.getAge());
                },
                () -> customers.add(customer)
        );
        return customer;
    }

    public boolean deleteById(Integer id) {
        return customers.removeIf(c -> c.getId().equals(id));
    }

    @PreDestroy
    public void close() {
        System.out.println("CustomerRepository close method called");
        customers.clear();
    }


}
