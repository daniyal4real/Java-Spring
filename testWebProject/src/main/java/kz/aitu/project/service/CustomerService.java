package kz.aitu.project.service;

import kz.aitu.project.entity.Customer;
import kz.aitu.project.entity.Order;
import kz.aitu.project.repository.CustomerRepository;
import kz.aitu.project.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;



@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;

    public CustomerService() {
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateById(Customer customer, long customerId) {
        return customerRepository.save(customer);
    }

    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> findCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public List<Customer> getCustomerList() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
        for (Customer customer:customers
             ) {
            long id = customer.getCustomerId();
            float total = 0;
            try{
                List<Order> orders = orderRepository.findAllByCustomerId(id);

                for (Order order:orders
                ) { total+= order.getTotalPrice();

                }
            }
            catch (Exception e){

            }

            customer.setTotal(total);
        }
        return customers;
    }
}
