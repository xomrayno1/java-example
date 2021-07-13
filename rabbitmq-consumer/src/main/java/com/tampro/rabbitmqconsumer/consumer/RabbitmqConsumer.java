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
public class RabbitmqConsumer {
	
	public static final String QUEUE = "nctam_queue";

	private static final Logger log = LoggerFactory.getLogger(RabbitmqConsumer.class);
	// tình trạng 
	//producer: fast producer
	//consumer: low consumer do thằng này validation , 
				//write database, send email ....
	// dẫn đến message cứ đọc vào queue mà thằng consumer đọc ko kịp
	// vào message mà message đó deplay 2s 
		//trong 2s đó có thêm 1 message vào thì consumer nó chưa đọc
			// nên queue sẽ lưu lại cứ thế dồn lại
	
	@RabbitListener(queues = QUEUE, concurrency = "3")
	public void listenMessage(String emp) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = mapper.readValue(emp, Employee.class);
		log.info(" get message nctam_queue : {} on thread {}", employee, Thread.currentThread().getName());
		
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(2000));// giả lập delay
		} catch (InterruptedException e) {
			// TODO Auto-generatezd catch block
			e.printStackTrace();
		}
	}
}
