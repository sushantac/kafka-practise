package com.kafka.kafkapractise.services;

import java.util.logging.Logger;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.kafkapractise.model.Message;

@Service
public class MessageProducer {

	private static final Logger logger = Logger.getLogger(MessageProducer.class.toString());
	
	@Value("${custom.topic-name}")
	private String TOPIC;

	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	public void sendMessage(Message message) {
		this.kafkaTemplate.send(TOPIC, message.getId().toString(), message);
	}
}