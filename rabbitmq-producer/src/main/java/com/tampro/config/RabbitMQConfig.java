package com.tampro.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	public static final String QUEUE = "nctam_queue";
	public static final String EXCHANGE = "nctam_exchange";
	public static final String ROUTING_KEY = "nctam_routingkey";
	
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE);
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(EXCHANGE);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	
	 
	
}
