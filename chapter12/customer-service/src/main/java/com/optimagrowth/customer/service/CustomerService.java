package com.optimagrowth.customer.service;

import java.util.*;

import com.optimagrowth.customer.model.Customer;
import com.optimagrowth.customer.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.optimagrowth.customer.config.ServiceConfig;

@Service
public class CustomerService {

	@Autowired
	MessageSource messages;

    @Autowired
    private CustomerRepository customerRepository;

	@Autowired
	ServiceConfig config;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public Customer getCustomer(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        Customer customer1 = customer.orElseThrow(() -> new IllegalArgumentException("Customer Not Found"));
        return customer1.withComment(config.getExampleProperty());
    }

    public List<Customer> getCustomerByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);

    }

    public Customer updateCustomer(String customerId, Customer customer) {
        Customer customerToUpdate = getCustomer(customerId);

        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setAddress(customer.getAddress());
        customerRepository.save(customerToUpdate);

        return customerToUpdate.withComment(config.getExampleProperty());
    }

    public Customer createCustomer(Customer customer) {
        customerRepository.save(customer);

        return customer.withComment(config.getExampleProperty());
    }

    public String deleteCustomer(String customerId) {
        String responseMessage = null;
        customerRepository.deleteById(customerId);
        responseMessage = String.format("Customer: %s Deleted Successfully", customerId);
        return responseMessage;
    }

    private void randomlyRunLong(){
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        if (randomNum==3) sleep();
    }
    private void sleep(){
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
