package com.tampro.Elasticsearch01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.Elasticsearch01.domain.Customer;
import com.tampro.Elasticsearch01.repository.CustomerRepository;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository cusRepo;
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping("/{cusId}")
	public Customer getCustomer(@PathVariable String cusId) {
		LOG.info("Getting customer with ID: {}", cusId);
		Customer customer = cusRepo.findById(cusId).orElse(null);
		LOG.info("Customer with ID: {} is {}", cusId, customer);
		return customer;
	}
	
	@PostMapping
	public void save(@RequestBody Customer customer) {
		LOG.info("save customer with customer: {}", customer);
		cusRepo.save(customer);
		LOG.info("Customer save successfully: {} ", customer);
	}
}
