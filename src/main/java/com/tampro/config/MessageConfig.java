package com.tampro.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;


//#1
@Configuration
public class MessageConfig {
	//https://viblo.asia/p/tim-hieu-ve-rabbitmq-OeVKB8bMlkW
	
	public static final String QUEUE = "nct_queue";
	public static final String EXCHANGE = "nct_exchange";
	public static final String ROUTING_KEY = "nct_routingKey";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE);
	}
	
	@Bean
	public TopicExchange exchange() { //type topic exchange;
		return new TopicExchange(EXCHANGE);
	}
		
	@Bean // Để nhận được message, queue phải được nằm trong ít nhất 1 Exchange
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	
	@Bean
	public MessageConverter converter() {	 
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}

}
