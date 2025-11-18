package com.optimagrowth.customer.repository;

import com.optimagrowth.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,String>  {
    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
