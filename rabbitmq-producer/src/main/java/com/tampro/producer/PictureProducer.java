package com.tampro.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tampro.entity.Picture;

//demo exchange direct

@Service
public class PictureProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public void sendMessage(Picture pic) {
		try {
			var json = objectMapper.writeValueAsString(pic);
			rabbitTemplate.convertAndSend("x.picture", pic.getType(), json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
