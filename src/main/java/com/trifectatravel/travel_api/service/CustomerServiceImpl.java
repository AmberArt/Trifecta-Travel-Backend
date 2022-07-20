package com.trifectatravel.travel_api.service;

import com.trifectatravel.travel_api.repositories.CustomerRepository;
import com.trifectatravel.travel_api.repositories.entities.Customer;
import com.trifectatravel.travel_api.repositories.entities.TravelPackage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with ID %d not found.".formatted(customerId));
        }
        return customer.get();
    }
}
