package com.onemorecode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.onemorecode.services.IConsumerService;

@SpringBootApplication
public class ConsumerApplication {

	
	@Autowired
	private IConsumerService service;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
