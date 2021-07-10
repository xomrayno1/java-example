package com.tampro.rabbitmqconsumer.consumer;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tampro.entity.Employee;

@Component
public class HumanConsumer {
	
	
	private static final Logger log = LoggerFactory.getLogger(HumanConsumer.class);

	
	@RabbitListener(queues = "q.hr.accounting", concurrency = "3")
	public void listenMessage(String emp) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = mapper.readValue(emp, Employee.class);
		log.info(" get message q.hr.accounting : {} on thread {}", employee, Thread.currentThread().getName());
		
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(2000));// giả lập delay
		} catch (InterruptedException e) {
			// TODO Auto-generatezd catch block
			e.printStackTrace();
		}
	}
	
	
	@RabbitListener(queues = "q.hr.marketing", concurrency = "3")
	public void listenMarketing(String emp) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = mapper.readValue(emp, Employee.class);
		log.info(" get message q.hr.marketing : {} on thread {}", employee, Thread.currentThread().getName());
		
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(2000));// giả lập delay
		} catch (InterruptedException e) {
			// TODO Auto-generatezd catch block
			e.printStackTrace();
		}
	}
}
