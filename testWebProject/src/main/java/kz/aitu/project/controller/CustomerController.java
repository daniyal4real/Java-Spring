package kz.aitu.project.controller;

import kz.aitu.project.entity.Authorization;
import kz.aitu.project.entity.Customer;
import kz.aitu.project.service.AuthorizationService;
import kz.aitu.project.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private CustomerService customerService;
    private AuthorizationService authorizationService;

    @GetMapping("/api/customers")
    public ResponseEntity<?> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAll());
    }


    @PostMapping("/api/customers")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.create(customer));
    }
    @GetMapping("/api/customers/list")
    public ResponseEntity<?> getCustomersLists(){return ResponseEntity.ok(customerService.getCustomerList());}

    @PutMapping("/api/customers/{customerId}")
    public ResponseEntity<?> updateCustomerById(@RequestBody Customer customer, @PathVariable long customerId){
        return ResponseEntity.ok(customerService.updateById(customer, customerId));
    }

    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomerById(@PathVariable long customerId){
        customerService.deleteById(customerId);
    }

    @GetMapping("/api/customers/me")
    public ResponseEntity<?> getMe(@RequestHeader("Authorization") String token) throws Exception {
        Authorization authorization = authorizationService.getAuthByToken(token);
        return ResponseEntity.ok(customerService.findCustomerById(authorization.getCustomerId()).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }
}
