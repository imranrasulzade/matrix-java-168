package com.example.matrix168.controller;

import com.example.matrix168.model.Customer;
import com.example.matrix168.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        customerService.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Customer created successfully. ID:"+ customer.getId());
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAll())   ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Customer customer = customerService.getById(id);
        if (customer == null) {
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Integer id, @RequestBody Customer updatedCustomer) {
        boolean updated = customerService.update(id, updatedCustomer);
        if (updated) {
            return ResponseEntity.ok("ID: " + id + " updated successfully. ");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        boolean deleted = customerService.delete(id);
        if (deleted) {
            return ResponseEntity.ok("ID: " + id + " deleted successfully. ");
        }
        return ResponseEntity.notFound().build();
    }


}
