package com.tampro.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tampro.config.RabbitMQConfig;
import com.tampro.entity.Employee;

@Service
public class EmployeeJsonProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public void sendMessage(Employee emp) {
		try {
			var json = objectMapper.writeValueAsString(emp);
			rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
