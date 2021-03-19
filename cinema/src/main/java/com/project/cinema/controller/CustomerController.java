package com.project.cinema.controller;

import com.project.cinema.entity.Customer;
import com.project.cinema.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }



    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/api/customers/{id}")
    public List<Customer> getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/api/customers")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        return  ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PutMapping("/api/customers/{id}")
    public ResponseEntity<?> updateCustomerById(@RequestBody Customer customer, @PathVariable int id){
        return ResponseEntity.ok(customerService.updateCustomerById(customer, id));
    }

    @DeleteMapping("/api/customers/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerService.deleteCustomerById(id);
    }
}
