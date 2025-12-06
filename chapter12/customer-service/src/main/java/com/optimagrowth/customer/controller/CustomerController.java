package com.optimagrowth.customer.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;

import com.optimagrowth.customer.model.Customer;
import com.optimagrowth.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/customer")
public class CustomerController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") String customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/search", params = {"firstName", "lastName"}, method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomerByFirstNameAndLastName(
            @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        List<Customer> customers = customerService.getCustomerByFirstNameAndLastName(firstName, lastName);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PutMapping(value="/{customerId}")
    public ResponseEntity<Customer> updateInventory(
            @PathVariable("customerId") String customerId, @RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(customerId, customer), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createInventory(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<String> deleteInventory(@PathVariable("customerId") String customerId) {
        return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);
    }

}
