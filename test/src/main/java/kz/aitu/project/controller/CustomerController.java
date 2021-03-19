package kz.aitu.project.controller;


import kz.aitu.project.entity.Customer;
import kz.aitu.project.service.CustomerService;
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
        return customerService.getAll();
    }

    @GetMapping("/api/customers/{id}")
    public List<Customer> getCustomerById(@PathVariable int id){
        return customerService.getById(id);
    }

    @PostMapping("/api/customers")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.create(customer));
    }

    @PutMapping("/api/customers/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id, @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateById(id, customer)) ;
    }

    @DeleteMapping("/api/customers/{id}")
    public void deleteById(@PathVariable long id){
        customerService.deleteById(id);
    }
}
