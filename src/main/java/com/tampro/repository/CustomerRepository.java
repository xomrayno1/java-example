package com.tampro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tampro.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>{

	List<Customer> findAll();
	
}
