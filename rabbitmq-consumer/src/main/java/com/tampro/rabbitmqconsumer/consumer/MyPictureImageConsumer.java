package com.tampro.rabbitmqconsumer.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.tampro.entity.Picture;

@Service
public class MyPictureImageConsumer {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private static final Logger log = LoggerFactory.getLogger(MyPictureImageConsumer.class);

	//error nếu bị lỗi cứ đọc vô hạn
//	@RabbitListener(queues = "q.mypicture.image")
//	public void listenMessage(String message) throws JsonMappingException, JsonProcessingException {
//		var p = objectMapper.readValue(message, Picture.class);
//		if(p.getSize() > 9000) {
//			throw new IllegalArgumentException("Picture size too large : " +  p);
//		}
//		
//		log.info("On image : {} ", p.toString());
//	}
	
	//q.mypicture.image	argument (x-dead-letter-exchange:	x.mypicture.dlx)
	//Nếu q.mypicture.image message dead thì sẽ exchange x.mypicture.dlx => q.mypicture.dlx
	//-> Set up cái q.mypicture.image nếu message is dead -> send message exchange x.mypicture.dlx sang q.mypicture.dlx
/*
 * 	@RabbitListener(queues = "q.mypicture.image") 
	public void listenMessage(String message) throws JsonMappingException, JsonProcessingException {
		var p = objectMapper.readValue(message, Picture.class);
		if(p.getSize() > 9000) {
			throw new AmqpRejectAndDontRequeueException("Picture size too large : " +  p);
		}
		
		log.info("On image : {} ", p.toString());
	}
	
 */
	/// basic handle error
	@RabbitListener(queues = "q.mypicture.image") 
	public void listenMessage(Message message, Channel channel) throws IOException {
		var p = objectMapper.readValue(message.getBody(), Picture.class);
		if(p.getSize() > 9000) {
			channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
		}
		
		log.info("On image : {} ", p.toString());
		
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}
	
}
