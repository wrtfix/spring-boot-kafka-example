package com.onemorecode.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements IConsumerService{
	
	private final Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);
	
	@Override
	@KafkaListener(topics ="myfirst" , groupId="first_app")
	public void readMessage(String msg) {
		logger.info(String.format("#### -> Consumed message -> %s", msg));
	}

}
