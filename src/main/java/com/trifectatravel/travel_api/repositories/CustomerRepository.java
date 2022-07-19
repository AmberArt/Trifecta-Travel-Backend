package com.trifectatravel.travel_api.repositories;

import com.trifectatravel.travel_api.repositories.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
