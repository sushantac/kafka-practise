package com.kafka.kafkapractise.services;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.kafka.kafkapractise.model.Message;

@Service
public class MessageProducer {

	private static final Logger logger = Logger.getLogger(MessageProducer.class.toString());

	@Value("${app.kafka.topic-name}")
	private String TOPIC;

	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	public void sendMessageSync(final Message message) {
		
		try {
			kafkaTemplate.send(TOPIC, message.getId().toString(), message).get(10, TimeUnit.SECONDS);
			logger.info("Message sent!");
	    }
	    catch (ExecutionException e) {
	    	logger.info("Message sent failed!");
			e.printStackTrace();
	    }
	    catch (TimeoutException | InterruptedException e) {
	    	logger.info("Message sent failed! Timed out...");
			e.printStackTrace();
	    }
		
	}

	public void sendMessageAsync(final Message message) {
		
		ListenableFuture<SendResult<String, Message>> future = kafkaTemplate.send(TOPIC, message.getId().toString(), message);
		
		future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {

			@Override
			public void onSuccess(SendResult<String, Message> result) {
				logger.info("Message sent!");
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.info("Message sent failed!");
				ex.printStackTrace();
			}

		});
	}
}