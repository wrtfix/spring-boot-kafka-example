package com.onemorecode.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerMessage implements IProducerMessage{
	
	public static Logger log = LoggerFactory.getLogger(ProducerMessage.class);
	
	@Autowired
	private KafkaTemplate<String,String> first_producer;  


	@Override
	public void sendMessage(String msg) {
		log.info(msg);
		first_producer.send("myfirst", msg);
	}

}
