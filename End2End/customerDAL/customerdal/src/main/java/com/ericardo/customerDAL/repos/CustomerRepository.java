package com.ericardo.customerDAL.repos;

import org.springframework.data.repository.CrudRepository;

import com.ericardo.customerDAL.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
