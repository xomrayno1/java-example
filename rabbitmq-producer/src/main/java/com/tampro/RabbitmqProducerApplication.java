package com.tampro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.tampro.entity.Employee;
import com.tampro.entity.Picture;
import com.tampro.producer.EmployeeJsonProducer;
import com.tampro.producer.HumanResourceProducer;
import com.tampro.producer.PictureProducer;
import com.tampro.producer.RabbitMQProducer;

@SpringBootApplication
@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner{
	
	@Autowired
	RabbitMQProducer rabbitProducer;
	
	@Autowired
	private EmployeeJsonProducer employeeJsonProducer;
	
	@Autowired
	private HumanResourceProducer humanResourceProducer;

	@Autowired
	private PictureProducer pictureProducer;
	
	private static final Logger log = LoggerFactory.getLogger(RabbitmqProducerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 
		/*
		 * demo exchange topic
		 * */	
//		Employee employee = new Employee("123", "Nguyen Chi Tam");
//		employeeJsonProducer.sendMessage(employee);
//		
		/*
		 * demo exchange fanout
		 * */	
//		Employee employeed = new Employee("12345", "Nguyen Chi Tam");
//		humanResourceProducer.sendMessage(employeed);

		/*
		 * demo exchange direct
		 * */
		Picture picture = new Picture("anh ", "jpg", "http://localhost:anh", 100);
		pictureProducer.sendMessage(picture);
		
		Picture picture1 = new Picture("anh 1", "svg", "http://localhost:anh1", 100);
		pictureProducer.sendMessage(picture1);
		
		Picture picture2 = new Picture("anh 2", "png", "http://localhost:anh2", 200);
		pictureProducer.sendMessage(picture2);
	}
	
	

}
