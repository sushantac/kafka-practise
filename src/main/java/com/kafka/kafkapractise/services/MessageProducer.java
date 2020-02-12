package com.kafka.kafkapractise.services;

import java.util.logging.Logger;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

	private static final Logger logger = Logger.getLogger(Producer.class.toString());
	private static final String TOPIC = "first_topic";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		this.kafkaTemplate.send(TOPIC, message);
	}
}