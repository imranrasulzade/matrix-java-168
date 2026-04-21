package controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    List<Customer> customers = new ArrayList<>();

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customers;
    }

}
