package com.maheshkumarvaka.rabbitmqproducer.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maheshkumarvaka.rabbitmqproducer.model.Programmer;

@RestController
@RequestMapping("/programmer")
public class MessagePublisher {
	@Autowired
	private RabbitTemplate template;
	
	private final Logger log = LoggerFactory.getLogger(MessagePublisher.class);
	
	@Value("${demo.rabbitmq.exchange}")
	private String appexchange;
	
	@Value("${demo.rabbitmq.routingkey}")
	private String approutingkey;
	
	@PostMapping("/publish")
	public String publishMessage(@RequestBody Programmer programmer) {
		template.convertAndSend(appexchange,approutingkey,programmer);
		log.info("Message Sent = " + programmer);
		return "Message Published Successfully";		
	}
}
