package com.tampro.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tampro.entity.Picture;

@Service
public class MyPictureProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public void sendMessage(Picture picture) throws JsonProcessingException {
		var json = mapper.writeValueAsString(picture);
		rabbitTemplate.convertAndSend("x.mypicture", "", json);
	}
}
