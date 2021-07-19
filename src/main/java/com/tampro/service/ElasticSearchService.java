package com.tampro.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tampro.common.CommonUtil;
import com.tampro.common.SearchUtils;
import com.tampro.domain.Customer;
import com.tampro.repository.CustomerRepository;

@Service
public class ElasticSearchService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ElasticSearchService.class);
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	private CustomerRepository customerRepository;
	private RestHighLevelClient restHighLevelClient;
	
	@Autowired
	public ElasticSearchService(CustomerRepository customerRepository, RestHighLevelClient restHighLevelClient) {
		this.customerRepository = customerRepository;
		this.restHighLevelClient = restHighLevelClient;
	}

	@Scheduled(cron = "0 */3 * * * *")
	@Transactional
	public void sync() {
		LOG.info("Start Sync - {}", LocalDateTime.now());
		try {
			syncCustomer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.info("Error Sync - {}", e);
			e.printStackTrace();
		}
		LOG.info("End Sync - {}", LocalDateTime.now());
	}
	
	private void syncCustomer() throws IOException {
		List<Customer> customers = customerRepository.findAll();
		for(Customer customer : customers) {
			save(customer);
		}
	}

	public void save(Customer customer) throws IOException {
		if(customer != null) {
			IndexRequest indexRequest = new IndexRequest(CommonUtil.INDICES_CUSTOMER);
			indexRequest.id(customer.getId());
			indexRequest.source(MAPPER.writeValueAsString(customer), XContentType.JSON);
			restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
		}
	}
	
	public List<Customer> getCustomerBySearch(String name) {
		 
		try {
			SearchRequest searchRequest = 
					SearchUtils.buildSearchRequest(CommonUtil.INDICES_CUSTOMER, "name", name);
			SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			
			SearchHit[] searchHits = response.getHits().getHits();
			List<Customer> customers = new  ArrayList<Customer>();
			for(SearchHit searchHit: searchHits) {
				String source = searchHit.getSourceAsString();
				Customer customer =	MAPPER.readValue(source, Customer.class);
				customers.add(customer);
			}
			LOG.info("Search customer by search name success - {}", name);
			return customers;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.info("Search customer by search name failed - {}", e );
			return null;
		}
	}
	
}
