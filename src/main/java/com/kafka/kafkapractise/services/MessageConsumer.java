package com.kafka.kafkapractise.services;

import java.util.logging.Logger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.kafka.kafkapractise.model.Message;

@Service
public class MessageConsumer {

	private static final Logger logger = Logger.getLogger(MessageProducer.class.toString());

	@KafkaListener(topics = "${app.kafka.topic-name}", groupId = "${spring.kafka.consumer.group-id}")
	public void listen(@Payload Message message) {

		logger.info(message.toString());

	}

//	@KafkaListener(topics = "first_topic")
//	public void receive(@Payload Message message, @Headers MessageHeaders headers) {
//		logger.info("received message -> " + message);
//		headers.keySet().forEach(key -> logger.info(key + " -> " + headers.get(key)));
//	}

}
