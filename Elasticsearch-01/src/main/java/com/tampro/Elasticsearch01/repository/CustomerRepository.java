package com.tampro.Elasticsearch01.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.tampro.Elasticsearch01.domain.Customer;

@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer, String>{
	
	List<Customer> findByName(String name);
}
