package com.tampro.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tampro.common.CommonUtil;
import com.tampro.domain.Customer;
import com.tampro.repository.CustomerRepository;

@Service
public class ElasticSync {
	
	private static final Logger LOG = LoggerFactory.getLogger(ElasticSync.class);
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	private CustomerRepository customerRepository;
	private RestHighLevelClient restHighLevelClient;
	
	@Autowired
	public ElasticSync(CustomerRepository customerRepository, RestHighLevelClient restHighLevelClient) {
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
	
}
