package com.kafka.kafkapractise.controller;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.kafkapractise.model.Message;
import com.kafka.kafkapractise.services.MessageProducer;

@RestController
@RequestMapping("/kafka")
public class KafkaRestController {

	@Autowired
	private final MessageProducer producer;

	public KafkaRestController(MessageProducer producer) {
		this.producer = producer;
	}

	@RequestMapping(path = "/publish", method = RequestMethod.POST)
	public void sendMessageToKafkaTopic(@RequestBody String message) {
		
		IntStream.range(1, 20).forEach(i -> producer.sendMessage(new Message(i, message)));
		
	}
}