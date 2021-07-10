package com.tampro.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.config.RabbitMQConfig;

@Service
public class RabbitMQProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendHello(String name) {
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, "Hello " + name);
		
		//exchange the name of the exchange
		//routingKey the routing key
		//object a message to send
	}
	//exchange distribute message to queue: phân phối message vào queue 
	// based on message routing key : dựa trên routing key
	//exchange : fanout, direct, topic
	
	//fanout: multiple queues for single message: nhiều queues cho 1 message
	//		 Broadcast to all queues bound to it : phát cho tất cả queue nó liết kết
	
	//direct: send to selective queue: Gửi đến hàng đợi chọn lọc (sử dụng điều kiện để distribute message to queue)
		//  based on routing key: dựa trên routing key
		// 	message can be discarded:  tin nhắn có thể bị loại bỏ
	
	private int i = 0;
	
//	@Scheduled(fixedDelay = 100)
//	public void getMessage() {
//		i++;
//		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, "logger i = " + i);
//	}

	
	
}

