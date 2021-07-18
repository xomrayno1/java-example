package com.tampro.Elasticsearch01.service;

import java.util.List;

import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
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
	
	public List<Customer> findAll() {
		return cusRepo.findAll();
	}
	
	public Page<Customer> getListByName(String name){
		return cusRepo.findByName(name, PageRequest.of(0, 10));
	}
	
	public List<Customer> searchByAddress(String address){
		return cusRepo.findByAddress(address);
	}
}
