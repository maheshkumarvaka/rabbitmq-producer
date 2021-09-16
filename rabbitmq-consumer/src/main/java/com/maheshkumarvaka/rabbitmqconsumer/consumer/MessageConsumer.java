package com.maheshkumarvaka.rabbitmqconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maheshkumarvaka.rabbitmqconsumer.model.Programmer;
@Component
public class MessageConsumer {	

	private final Logger log = LoggerFactory.getLogger(MessageConsumer.class);
		
    @RabbitListener(queues = "${demo.rabbitmq.queue}")
    public void consumeMessageFromQueue(Programmer programmer){

        log.info("Message Received = " + programmer);
    }
}
