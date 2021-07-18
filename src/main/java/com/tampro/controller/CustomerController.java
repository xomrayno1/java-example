package com.tampro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.common.CommonUtil;
import com.tampro.domain.Customer;
import com.tampro.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	
	//search on elasticsearch
	@GetMapping("/search/{name}")
	public List<Customer> getAllBySearchName(@PathVariable String name){
		LOG.info(" get customer by name {}", name);
		return customerService.getCustomerBySearch(name);
	}
	
	@GetMapping("/{cusId}")
	public Customer getCusById(@PathVariable String cusId){
		LOG.info(" get customer by id {}", cusId);
		return customerService.getById(cusId);
	}

	@PostMapping
	public String saveCustomer(@RequestBody Customer customer){
		try {
			if(customer.getId() == null) {
				customer.setId(CommonUtil.getUUID());
			}
			Customer customered = customerService.saveCus(customer);
			LOG.info("save successfully : {} ", customered);
			return "save successfully";
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("save failed : {} ", e);
			return "save failed"; 
		}
	}
	
}
