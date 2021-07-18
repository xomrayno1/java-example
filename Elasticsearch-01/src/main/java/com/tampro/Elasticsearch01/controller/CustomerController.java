package com.tampro.Elasticsearch01.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.Elasticsearch01.domain.Customer;
import com.tampro.Elasticsearch01.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService cusService;
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
	
	@GetMapping
	public List<Customer> getAll() {
		return cusService.findAll();
	}
	
	@GetMapping("/search/address/{address}")
	public List<Customer> getListSearchAddress(@PathVariable String address) {
		List<Customer> page = cusService.searchByAddress(address);
		return page;
	}
	
	@GetMapping("/search/name/{name}")
	public Page<Customer> getListSearchName(@PathVariable String name) {
		Page<Customer> page = cusService.getListByName(name);
		return page;
	}
	
	
	@GetMapping("/{cusId}")
	public Customer getCustomer(@PathVariable String cusId) {
		LOG.info("Getting customer with ID: {}", cusId);
		Customer customer = cusService.findById(cusId);
		LOG.info("Customer with ID: {} is {}", cusId, customer);
		return customer;
	}
	
	@PostMapping
	public void save(@RequestBody Customer customer) {
		LOG.info("save customer with customer: {}", customer);
		cusService.save(customer);
		LOG.info("Customer save successfully: {} ", customer);
	}
}
