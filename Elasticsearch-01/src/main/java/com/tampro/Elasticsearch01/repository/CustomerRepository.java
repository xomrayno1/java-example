package com.tampro.Elasticsearch01.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.tampro.Elasticsearch01.domain.Customer;
/*
 * https://docs.spring.io/spring-data/elasticsearch/docs/1.0.0.M1/reference/html/elasticsearch.repositories.html
 */

@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer, String>{
	
	List<Customer> findByName(String name);
	
	List<Customer> findAll();
	
	Page<Customer> findByName(String name, Pageable pageable);  //Sample , key word is
	
	//@Query("{\"bool\" : {\"must\" : {\"field\": {\"address\" : \"?\"}}}}") //Elasticsearch Query String
//	List<Customer> findByAddressContaining(String address);->error //Actually Spring data apis (containing or startWith) does not work with space in String 
	
	List<Customer> findByAddress(String address);
	
//	{ // must []-> and, is , should -> or
//		"bool": {
//			"must" : [
//			          {
//			        	"field": {
//			        		"name":  "?"
//			        	}  
//			          },
//			          {
//				        "field": {
//				        	"address":  "?"
//				        }  
//				      }
//			        ]
//		}
//	}
//	
}
