package com.tampro.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.tampro.config.MessageConfig;
import com.tampro.dto.OrderStatus;

@Component
public class User {
	// lắng nghe và lấy message từ trong QUEUE ra , nếu có lấy ra luôn 
	@RabbitListener(queues = MessageConfig.QUEUE)
	public void consumerMessageFromQueue(OrderStatus orderStatus) {
		 System.out.println("Message received from queue : " + orderStatus);
	}
	

}
