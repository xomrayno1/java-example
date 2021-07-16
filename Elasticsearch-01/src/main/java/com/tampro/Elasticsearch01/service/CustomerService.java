package com.tampro.Elasticsearch01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.Elasticsearch01.domain.Customer;
import com.tampro.Elasticsearch01.repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository cusRepo;

	@Autowired
	public CustomerService(CustomerRepository cusRepo) {
		this.cusRepo = cusRepo;
	}

	public void save(final Customer customer) {
		cusRepo.save(customer);
	}
		
	public Customer findById(final String cusId) {
		return cusRepo.findById(cusId).orElse(null);
	}
	
}
