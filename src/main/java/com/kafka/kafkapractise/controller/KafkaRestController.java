package com.kafka.kafkapractise.controller;

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

	@RequestMapping(path = "/publishSync", method = RequestMethod.POST)
	public void sendMessageToKafkaTopicSync(@RequestBody Message message) {
		
		//IntStream.range(1, 20).forEach(i -> producer.sendMessageSync(new Message(i, message)));
		
		producer.sendMessageSync(message);
		
	}
	
	@RequestMapping(path = "/publishAsync", method = RequestMethod.POST)
	public void sendMessageToKafkaTopicAsync(@RequestBody Message message) {
		
		//IntStream.range(1, 20).forEach(i -> producer.sendMessageAsync(new Message(i, message)));
		
		producer.sendMessageAsync(message);
	}
}