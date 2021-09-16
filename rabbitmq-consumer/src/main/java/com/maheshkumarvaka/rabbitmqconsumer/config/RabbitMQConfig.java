package com.maheshkumarvaka.rabbitmqconsumer.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${demo.rabbitmq.queue}")
	private String appqueue;
	
	@Value("${demo.rabbitmq.exchange}")
	private String appexchange;
	
	@Value("${demo.rabbitmq.routingkey}")
	private String approutingkey;
	
	@Bean
	public Queue messagequeue() {
		return new Queue(appqueue);
	}
	
	@Bean
	public TopicExchange messageexchange() {
		return new TopicExchange(appexchange);
	}
	
	@Bean
	public Binding binder(Queue queue,TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(approutingkey);
	}
	
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		RabbitTemplate template=new RabbitTemplate(connectionFactory);
		template.setMessageConverter(messageConverter());
		return template;
	}
}
