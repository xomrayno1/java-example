package com.tampro.rabbitmqconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tampro.entity.Picture;

//demo exchange direct

@Service
public class PictureConsumer {

	ObjectMapper mapper = new ObjectMapper();
	
	private static final Logger log = LoggerFactory.getLogger(PictureConsumer.class);
	
	@RabbitListener(queues = "q.picture.image")
	public void listenPictureImageMessage(String json) throws JsonMappingException, JsonProcessingException {
		Picture picture = mapper.readValue(json, Picture.class);
		log.info(" get message q.picture.image  {}", picture );
	}
	
	@RabbitListener(queues = "q.picture.vector")
	public void listenPictureVectorMessage(String json) throws JsonMappingException, JsonProcessingException {
		Picture picture = mapper.readValue(json, Picture.class);
		log.info(" get message q.picture.vector  {}", picture );
	}
}
