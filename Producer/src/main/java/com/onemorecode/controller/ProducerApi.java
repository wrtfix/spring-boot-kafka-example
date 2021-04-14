package com.onemorecode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onemorecode.services.IProducerMessage;

@RestController
@RequestMapping(value ="/producer")
public class ProducerApi {
	
	@Autowired
	private IProducerMessage service;
	
	private static Logger log = LoggerFactory.getLogger(ProducerApi.class);
	
	@PostMapping (value="/sendMessage")
	public ResponseEntity sendMessage(@RequestBody String msg) {
		log.info("Esta ingresando informacion");
		service.sendMessage(msg);
		return new ResponseEntity("Se envio el mensaje con exito",HttpStatus.ACCEPTED);
	}
}
