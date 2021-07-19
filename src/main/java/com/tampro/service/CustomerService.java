package com.tampro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.domain.Customer;
import com.tampro.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCus(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer getById(String cusId) {
		return customerRepository.findById(cusId).orElse(null);
	}

}
