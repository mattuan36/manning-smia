package com.optimagrowth.customer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optimagrowth.customer.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,String>  {
    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
